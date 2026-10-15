package edu.odu.cs.cs330.items;

import java.util.Objects;

/**
 * This class represents one tool--as found in most video games. This includes
 * pickaxes and shovels.
 *
 * Tools may not be stacked. All Constructors must initialize Item::stackable
 * to false.
 */
@SuppressWarnings({
    "PMD.BeanMembersShouldSerialize",
    "PMD.CloneMethodReturnTypeMustMatchClassName",
    "PMD.CloneThrowsCloneNotSupportedException",
    "PMD.LawOfDemeter",
    "PMD.OnlyOneReturn",
    "PMD.ProperCloneImplementation",
    "PMD.MethodArgumentCouldBeFinal",
    "PMD.LocalVariableCouldBeFinal",
    "PMD.ShortClassName",
})
public class Tool extends Equippable {
    /**
     * Format used to generate a printable representation.
     */
    public static final String FMT_STR = String.join(
        "",
        "  Nme: %s%n",
        "  Dur: %d%n",
        "  Spd: %d%n",
        "  Mtl: %s%n",
        "  Mdr: %s (Lvl %d)%n"
    );

    /**
     * Base operation (e.g., harvest/mine) speed.
     */
    protected int speed;

    /**
     * Default to an unstackable tool with zero speed.
     */
    public Tool()
    {
        super();

        this.speed = 0;
    }

    /**
     * Retrieve tool speed.
     *
     * @return how quickly a tool operates
     */
    public int getSpeed()
    {
        return this.speed;
    }

    /**
     * Set tool speed.
     *
     * @param spd new speed
     */
    public void setSpeed(int spd)
    {
        this.speed = spd;
    }

    @Override
    public int requiredNumberOfValues()
    {
        // What is the correct return value?
        return 6;
    }

    @Override
    public void fromTokens(String[] tokens)
    {
        this.setName(tokens[0]);

        // Complete this method.
        this.setMaterial(tokens[1]);
        this.setDurability(Integer.parseInt(tokens[2]));
        this.setSpeed(Integer.parseInt(tokens[3]));
        this.setModifier(tokens[4]);
        this.setModifierLevel(Integer.parseInt(tokens[5]));
        

    }

    /**
     * Clone--i.e., copy--this Tool.
     */
    @Override
    public Item clone()
    {
        Tool cpy = new Tool();

        cpy.setName(this.name);

        cpy.setDurability(this.getDurability());
        cpy.setSpeed(this.speed);
        cpy.setMaterial(this.getMaterial());
        cpy.setModifier(this.getModifier());
        cpy.setModifierLevel(this.getModifierLevel());

        return cpy;
    }

    /**
     * Check for logical equivalence--based on name, speed, material, modifier,
     * and modifierLevel
     *
     * @param rhs object for which a comparison is desired
     */
    @Override
    public boolean equals(Object rhs)
    {
        if (!(rhs instanceof Tool)) {
            return false;
        }

        Tool rhsItem = (Tool) rhs;

        if(!(this.name.equals(rhsItem.name))){
            return false;
        }
        else if(this.getSpeed() != rhsItem.getSpeed()){
            return false;
        }
        else if(!(this.getMaterial().equals(rhsItem.getMaterial()))){
            return false;
        }
        else if(!(this.getModifier().equals(rhsItem.getModifier()))){
            return false;
        }
        else if(this.getModifierLevel() != rhsItem.getModifierLevel()){
            return false;
        }

        // Replace the return
        return this.name.equals(rhsItem.name);
    }

    /**
     * Compute hashCode using name, speed, material, modifier,
     * and modifierLevel.
     */
    @Override
    public int hashCode()
    {
        // Replace the return
        return Objects.hash(this.name, this.getSpeed(), this.getMaterial(), this.getModifier(), this.getModifierLevel());
    }

    /**
     * *Print* a Tool.
     */
    @Override
    public String toString()
    {
        // Use String.format and the provided FMT_STR
         return String.join(
            System.lineSeparator(),
            String.format(FMT_STR, super.getName(), this.getDurability(), this.getSpeed(), this.getMaterial(), this.getModifier(), this.getModifierLevel())     
            
        );
    }
}
