package problem6;

import problem6.models.Person;

import java.util.Comparator;

public enum PersonComparator implements Comparator<Person> {

    COMPARE_BY_NAME {
        public int compare(Person first, Person second) {
            int compare = Integer.compare(first.getName().length(), second.getName().length());
            if (compare == 0) {
                String symbolOne = String.valueOf(first.getName().charAt(0));
                String symbolTwo = String.valueOf(second.getName().charAt(0));
                compare = symbolOne.compareToIgnoreCase(symbolTwo);
            }
            return compare;
        }
    },
    COMPARE_BY_AGE {
        public int compare(Person first, Person second) {
            return Integer.compare(first.getAge(), second.getAge());
        }
    };

//    public static Comparator<Person> getComparator(final PersonComparator... multiOptions) {
//        return new Comparator<Person>() {
//            @Override
//            public int compare(Person first, Person second) {
//                for (PersonComparator multiOption : multiOptions) {
//                    int result = multiOption.compare(first, second);
//                    if (result != 0) {
//                        return result;
//                    }
//                }
//                return 0;
//            }
//        };
//    }

}
