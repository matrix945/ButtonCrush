package a6;

public class ShinyButtons {
	
	private int score;
	private boolean[][] selectionTable;
	
	public static byte RED = 0;
	public static byte ORANGE = 1;
	public static byte YELLOW = 2;
	public static byte GREEN = 3;
	public static byte BLUE = 4;
	public static byte LIGHT_GRAY = 5;
	public static byte DARK_GRAY = 6;
	
	public static byte ROWS = 8;
	
	private byte[][] buttonTable;
	
	public ShinyButtons() {	
		System.out.println("this is shinybuttons cons");
		selectionTable = new boolean [ROWS][ROWS];
		buttonTable = new byte[ROWS][ROWS];
		resetButtons();
		processTable();
	}
	
	public void resetButtons() {
		System.out.println("this is  resetButtons function");
		score = 0;
		for (int r=0; r<ROWS; r++)
			for (int c=0; c<ROWS; c++)
				buttonTable[r][c] = (byte)(Math.random()*7);
	}
	
	public byte getButton(int r, int c) { return buttonTable[r][c]; }
	public int getScore() {return score;}
	public boolean getSelectionTable(int r, int c) {return selectionTable[r][c];};
	public void setSelectionTable(int r, int c,boolean set) {selectionTable[r][c] = set;};
	
	public void swap(int row, int col, int r, int c){
		System.out.println("this is  swap function");
	    byte temp = buttonTable[row][col];
	    buttonTable[row][col] = buttonTable[r][c];
	    buttonTable[r][c] = temp;
	    processTable();
	}
	
	public void processTable(){
		System.out.println("this is  processtable function");
		 for (int i = 0; i < 8; i++){
		      int matches = 0;
		      for (int c = 1; c < 8; c++){        
		        if (buttonTable[i][c] == buttonTable[i][c-1]){
		          matches++;
		          if (matches >= 2){
		            selectionTable[i][c-2] = true;
		            selectionTable[i][c-1] = true;
		            selectionTable[i][c] = true;
		          }
		        }
		        else {
		        	if (matches >= 2) 
		        		score += 30 + (matches+3)*(matches-2)*15;
		        	matches = 0;
		        }
		        	
		      }
		      matches = 0;
		      for (int r = 1; r < 8; r++){        
		        if (buttonTable[r][i] == buttonTable[r-1][i]){
		          matches++;
		          if (matches >= 2){
		            selectionTable[r-2][i] = true;
		            selectionTable[r-1][i] = true;
		            selectionTable[r][i] = true;
		          }
		        }
		        else {
		        	if (matches >= 2) 
		        		score += 30 + (matches+3)*(matches-2)*15;
		        	matches = 0;
		        }

		      } 
		    }

	}
	
	
	public void cleanTable(){
		System.out.println("this is  cleantable function");
		boolean newPieceAdded = false;
		int r = 7;
		while (r >= 0) {
			newPieceAdded = false;
			for (int c = 0; c < 8; c++) {
				if (selectionTable[r][c]) {
					// move the pieces down now ...
					for (int r2 = r; r2 >= 1; r2 --){
						selectionTable[r2][c] = selectionTable[r2-1][c];
						buttonTable[r2][c] = buttonTable[r2-1][c];
					}
					// Add a new piece
					buttonTable[0][c] = (byte)(Math.random()*7);
					//set the piece color for piece at (0, c) to a valid random color index
					selectionTable[0][c] = false;
					//unselect piece at (0, c)
					newPieceAdded = true;
				}
			}
			if (!newPieceAdded)
				r--;
			}
	}
	
}