package pt.europeia.aed.igb.session28;

import java.util.Arrays;

/*
 * A useless value class created with a bunch of attributes of different types. 
 * The constructor and the hashCode() and equals() methods were generated
 * automatically using Eclipse's (Neon.3) code generator tools. Unless you have
 * good reason to believe you can provide a better implementation of the
 * hashCode() method (e.g., some of your attributes are calculated from other
 * attributes¹), it is safe to use the automatically generated version. 
 *
 * ¹However, if attributes calculated from other attributes are marked as
 * transient, by default they will not be included in the hash code calculation.
 */
public final class HashCodeGeneratorTester {

    private final int intOne;
    private final int intTwo;
    private final double doubleOne;
    private final double doubleTwo;
    private final String string;
    private final int[] ints;

    public HashCodeGeneratorTester(final int intOne, final int intTwo,
            final double doubleOne, final double doubleTwo, final String string,
            final int[] ints) {
        this.intOne = intOne;
        this.intTwo = intTwo;
        this.doubleOne = doubleOne;
        this.doubleTwo = doubleTwo;
        this.string = string;
        this.ints = ints;
    }

    @Override
    public int hashCode() {
        final int prime = 31;

        int result = 1;

        long temp;
        temp = Double.doubleToLongBits(doubleOne);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(doubleTwo);
        result = prime * result + (int) (temp ^ (temp >>> 32));

        result = prime * result + intOne;
        result = prime * result + intTwo;

        result = prime * result + Arrays.hashCode(ints);

        result = prime * result + ((string == null) ? 0 : string.hashCode());

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (getClass() != obj.getClass())
            return false;

        final HashCodeGeneratorTester other = (HashCodeGeneratorTester) obj;

        if (Double.doubleToLongBits(doubleOne) != Double
                .doubleToLongBits(other.doubleOne))
            return false;

        if (Double.doubleToLongBits(doubleTwo) != Double
                .doubleToLongBits(other.doubleTwo))
            return false;

        if (intOne != other.intOne)
            return false;

        if (intTwo != other.intTwo)
            return false;

        if (!Arrays.equals(ints, other.ints))
            return false;

        if (string == null) {
            if (other.string != null)
                return false;
        } else if (!string.equals(other.string))
            return false;

        return true;
    }

}

/*
 * Copyright 2017, Manuel Menezes de Sequeira.
 * 
 * This code is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * This code is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this code. If not, see http://www.gnu.org/licenses.
 */