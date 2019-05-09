package btreeLab;

import java.util.Scanner;

public class BTreeRunner {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		Scanner kb = new Scanner(System.in);

		while(true) {
			System.out.print("Enter an integer to add to tree or C to continue: ");
			if(kb.hasNextInt()) {
				tree.add(kb.nextInt());
				kb.nextLine();
			} else {
				String input = kb.nextLine();
				if(input.equals("C") || input.equals("c")) {
					break;
				} else {
					System.out.println("invalid input discarded");
				}
			}
		}

		boolean running = true;
		do {
			while(running == true) {
				int choice;
				while(true) {
					System.out.println("\n1. Add number to list");
					System.out.println("2. Search for number in list");
					System.out.println("3. Remove number from list");
					System.out.println("4. Print list");
					System.out.println("5. Exit program");
					System.out.print("Enter the number of the function you'd like to preform: ");
					if(kb.hasNextInt() == true) {
						choice = kb.nextInt();
						if(choice < 1 || choice > 5) {
							System.out.println('"' + choice + '"' + " was not an option");
						}else if(choice > 0 && choice < 6){
							break;
						}
					}else {
						kb.nextLine();
						System.out.println("invalid input discarded");
					}
				}
				switch(choice) {
				case 1:
					System.out.print("Enter an integer to add to tree: ");
					if(kb.hasNextInt()) {
						int input = kb.nextInt();
						tree.add(input);
						System.out.println(input + " was added to tree");
					} else {
						kb.nextLine();
						System.out.println("invalid input discarded");
					}
					break;
				case 2:
					System.out.print("Enter an integer to search for in tree: ");
					if(kb.hasNextInt() == true) {
						int input2 = kb.nextInt();
						if(tree.search(input2) == true) {
							System.out.println(input2 + " is in the tree");
						} else {
							while(true) {
								System.out.println(input2 + " is not in the list would you like to add it? ");
								int decision;
								while(true) {
									System.out.print("Enter 1 for yes, 2 for no: ");
									if(kb.hasNextInt()) {
										decision = kb.nextInt();
										if(decision == 1) {
											tree.add(input2);
											System.out.println(input2 + "was added to the list");
											break;
										} else if(decision < 1 || decision > 2) {
											System.out.println(decision + " was not a choice");
										} else {
											break;
										}
									} else {
										String wrong = kb.nextLine();
										System.out.println(wrong + " was not a choice");
									}
								}
								break;
							}
						}
					}
					break;
				case 3:
					System.out.print("Enter an integer to remove from tree: ");
					if(kb.hasNextInt()) {
						tree.remove(kb.nextInt());
					} else {
						kb.nextLine();
						System.out.println("invalid input discarded");
					}
					System.out.println("value has been removed");
					break;
				case 4:
					while(true) {
						System.out.println("\n1. InOrder");
						System.out.println("2. PreOrder");
						System.out.println("3. PostOrder");
						System.out.println("4. LevelOrder");
						System.out.print("Enter the number of the order you'd like to print in: ");
						if(kb.hasNextInt() == true) {
							int input4 = kb.nextInt();
							if(input4 == 1) {
								tree.printInOrder();
								break;
							} else if(input4 == 2) {
								tree.printPreOrder();
								break;
							} else if(input4 == 3) {
								tree.printPostOrder();
								break;
							} else if(input4 == 4) {
								tree.printLevelOrder();
								break;
							} else {
								System.out.println(input4 + " was not an option");
							}
						}else {
							kb.nextLine();
							System.out.println("invalid input discarded");
						}
					}
					break;
				case 5:
					running = false;
					kb.close();
					break;
				}
			}
		}while(running==true);
	}
}
