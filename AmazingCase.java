/** AmazingCase.java
 * Solve a maze
 * Lecture demo of backtracking
 * @author Kees Huizing
 * @date  23 Sep 2020
 */

class AmazingCase {
    static final char ME = '@';
    static final char EXIT = '>';
    static final char CRUMB = '.';
    static final char EMPTY = ' ';


    final int RNUM;
    final int CNUM;
    char maze[][]; // THE MAZE!!
    Pair exit;    

    // create a maze defined by array of Strings
    // assumes all Strings in map are of the same length
    AmazingCase(String[] map) {
        RNUM = map.length;
        CNUM = map[0].length();
        maze = new char[RNUM][CNUM];
        for (int r = 0; r < RNUM; r++) {
            maze[r] = map[r].toCharArray();
            int c = map[r].indexOf(EXIT);
            if (c >= 0) { 
                exit = new Pair(r, c);
            }
        }
    }

    // create a default maze, calling the other constructor
    AmazingCase() {
        this(new String[]{
            "##########",
            "#     #  #",
            "### ### ##",
            "#   #    #",
            "# #   # >#",
            "##########", // a comma after the last item is allowed lists like this in Java 
        });
    }

    void print() {
        for (int r = 0; r < maze.length; r++) {
            for (int c = 0; c < maze[r].length; c++) {
                System.out.print(maze[r][c]);
            }
            System.out.println();
        }
        pause(0.3);
    }

    // hold up execution for an amount of seconds
    void pause(double s) {
        try{ Thread.sleep((long)(s * 1000)); } catch(InterruptedException e) {}
    }

    // can I step on this tile?
    // assume p is a vaild position (coordinate pair) the maze
    boolean isFree(Pair p) {
        char ch = maze[p.r][p.c];
        return ch == EMPTY || ch == EXIT;
    }

    // is this coordinate pair within the maze?
    boolean withinBounds(Pair p) {
        return 0 <= p.r && p.r < RNUM && 0 <= p.c && p.c < CNUM;
    }

    // solve the thing, starting position defined here
    void solve() {
        explore(new Pair(1, 1));
    }

    // recursive solver: explore the maze from position 'me'
    // assume 'me' is a valid position in the maze
    boolean explore(Pair me) {
        maze[me.r][me.c] = ME;
        print();

        if (me.r == exit.r && me.c == exit.c) {
            return true;
        }

        /* exploring just two directions -- replaced by the for-loop */

        // Pair n = new Pair(me.r, me.c + 1);
        // if (withinBounds(n) && isFree(n)) {
        //     maze[me.r][me.c] = CRUMB;
        //     boolean hasExit = explore(n);
        //     if (hasExit) {
        //         return true;
        //     } else {
        //         maze[n.r][n.c] = EMPTY;
        //         maze[me.r][me.c] = ME;
        //         print();
        //     }
        // }

        // n = new Pair(me.r + 1, me.c);
        // if (withinBounds(n) && isFree(n)) {
        //     maze[me.r][me.c] = CRUMB;
        //     boolean hasExit = explore(n);
        //     if (hasExit) {
        //         return true;
        //     }
        // }

        // define the four possible directions
        // can be walls or even outside the maze
        Pair[] nexts = {
            new Pair(me.r - 1, me.c),        // up
            new Pair(me.r,     me.c - 1),   // left
            new Pair(me.r + 1, me.c),      // down
            new Pair(me.r,     me.c + 1), // right
        };

        // try all four directions
        for (int i = 0; i < nexts.length; i++) {
            Pair n = nexts[i];
            if (withinBounds(nexts[i]) && isFree(nexts[i])) {
                maze[me.r][me.c] = CRUMB; // don't explore this position anymore; all directions have been or will be taken care of
                boolean hasExit = explore(new Pair(n.r, n.c)); // recursive call
                if (hasExit) {
                    return true; // found a solution
                } else {
                    // backtracking
                    maze[n.r][n.c] = EMPTY; // remove the crumb so only the successful path will be visible
                    maze[me.r][me.c] = ME; // show that I am going back
                    print();              // ditto
                }
            }
        }


        return false;
    }

    
    public static void main(String[] a) {
        (new AmazingCase()).solve();
    }
}

// class that represents coordinate pairs, or positions, in the maze
class Pair {
    // instance vars are 'final', meaning they can't be changed
    // this means the Pair objects are 'immutable'
    // for immutable objects we allow that instance variables are accessed directly, e.g., by me.r,
    // instead of by calling a method
    final int r; // row index
    final int c; // column index

    Pair(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

