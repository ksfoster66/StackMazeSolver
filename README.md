A simple maze solving program. It reads in a maze that is written using zeroes, ones, and the letters S and E. S designates the start point, of which there must be one. E designates where the exit is, and there can be multiple or no exits. Ones represent walls and zeroes are navigable pathes.

Each movement taken from the start is added to the stack. If the there no available moves left that last movement is popped from the stack, the location in the maze redesignated as impassable, and the current locaiton is reverted to the prior location. If the maze solver ends back up at the start point with no available moves then the maze is unsolvable.

There is a custom stack class provided as it was part of the design requirement for the program. There is no real advantage to it other than demonstration purposes