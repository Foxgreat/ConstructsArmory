package c4.conarm.integrations.crafttweaker.materials;

import crafttweaker.annotations.ZenRegister;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenGetter;
import stanhebben.zenscript.annotations.ZenMethod;
import stanhebben.zenscript.annotations.ZenSetter;

@ZenClass("crafttweaker.conarm.IConArmMaterial")
@ZenRegister
public interface IConArmMaterial {

    @ZenGetter
    String getName();

    Object getInternal();

    @ZenGetter("definition")
    IConArmMatDefinition getDefinition();

    @ZenMethod
    boolean matches(IConArmMaterial var1);

    @ZenSetter("durabilityCore")
    void setDurabilityCore(float durability);

    @ZenGetter("durabilityCore")
    float getDurabilityCore();

    @ZenSetter("durabilityPlates")
    void setDurabilityPlates(float durability);

    @ZenGetter("durabilityPlates")
    float getDurabilityPlates();

    @ZenSetter("durabilityTrim")
    void setDurabilityTrim(float durability);

    @ZenGetter("durabilityTrim")
    float getDurabilityTrim();

    @ZenSetter("armor")
    void setArmor(float[] armor);

    @ZenGetter("armor")
    float[] getArmor();

    @ZenSetter("modifier")
    void setModifier(float modifier);

    @ZenGetter("modifier")
    float getModifier();

    @ZenSetter("toughness")
    void setToughness(float modifier);

    @ZenGetter("toughness")
    float getToughness();

}
