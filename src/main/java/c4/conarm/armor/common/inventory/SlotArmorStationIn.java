package c4.conarm.armor.common.inventory;

import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import slimeknights.tconstruct.library.tinkering.PartMaterialType;
import slimeknights.tconstruct.library.tools.IToolPart;

import java.util.Iterator;

/*This class is a re-implementation of the
SlotToolStationIn class from Tinkers' Construct
Tinkers' Construct is licensed under the MIT License
Find the source here: https://github.com/SlimeKnights/TinkersConstruct
 */
public class SlotArmorStationIn extends Slot
{
    public boolean dormant;
    public PartMaterialType restriction;
    public ItemStack icon;
    public Container parent;

    public SlotArmorStationIn(final IInventory inventoryIn, final int index, final int xPosition, final int yPosition, final Container parent) {
        super(inventoryIn, index, xPosition, yPosition);
        this.parent = parent;
    }

    public void onSlotChanged() {
        this.parent.onCraftMatrixChanged(this.inventory);
    }

    public boolean isItemValid(final ItemStack stack) {
        if (this.dormant) {
            return false;
        }
        if (this.restriction != null) {
            return stack != null && stack.getItem() instanceof IToolPart && this.restriction.isValidItem((IToolPart)stack.getItem());
        }
        return super.isItemValid(stack);
    }

    public boolean isDormant() {
        return this.dormant;
    }

    public void activate() {
        this.dormant = false;
    }

    public void deactivate() {
        this.dormant = true;
    }

    public void setRestriction(final PartMaterialType restriction) {
        this.restriction = restriction;
    }

    @SideOnly(Side.CLIENT)
    public void updateIcon() {
        this.icon = null;
        if (this.restriction != null) {
            final Iterator<IToolPart> iterator = this.restriction.getPossibleParts().iterator();
            while (iterator.hasNext() && this.icon == null) {
                this.icon = iterator.next().getOutlineRenderStack();
            }
        }
    }
}

