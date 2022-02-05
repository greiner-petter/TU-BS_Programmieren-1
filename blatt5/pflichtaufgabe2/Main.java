class Main {

    public static void main(String[] args) {

        Tree tree = new Tree(15);

        int[] set1 = {15, 21, 8, 41, 8, 5, 41, 33};
        int[] set2 = {18, 45, 36, 19, 3, 24, 19, 10};

        for (int i = 0; i < set1.length; i++) {
            tree.add(set1[i]);
        }

        System.out.println(tree.toString());
        System.out.println("The depth of the tree is " + tree.depth() + ".");
        System.out.println("Does the number 8 exist in the tree? " + tree.exists(8));
        System.out.println("Does the number 24 exist in the tree? " + tree.exists(24));
        System.out.println(tree.smallest() + " is the smallest number in the tree. ");
        System.out.println(tree.biggest() + " is the biggest number in the tree. ");
        System.out.println("Is the tree degenerate? " + tree.isDegenerate());

        for (int i = 0; i < set2.length; i++) {
            tree.add(set2[i]);
        }

        System.out.println(tree.toString());
        System.out.println("The depth of the tree is " + tree.depth() + ".");
        System.out.println("Does the number 8 exist in the tree? " + tree.exists(8));
        System.out.println("Does the number 24 exist in the tree? " + tree.exists(24));
        System.out.println(tree.smallest() + " is the smallest number in the tree. ");
        System.out.println(tree.biggest() + " is the biggest number in the tree. ");
        System.out.println("Is the tree degenerate? " + tree.isDegenerate());

    }
}
