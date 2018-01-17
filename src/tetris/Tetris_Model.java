package tetris;

public class Tetris_Model {

	public int HEIGHT;
	public int WIDTH;
	public boolean[][] cell;
	public int BlockCenterX;
	public int BlockCenterY;
	public int BlockType;

	public Tetris_Model(){
		HEIGHT = 16;
		WIDTH = 8;
		cell = new boolean[HEIGHT][WIDTH];
		for(int i=0; i<HEIGHT; i++){
			for(int j=0; j<WIDTH; j++){
				cell[i][j] = false;
			}
		}
		BlockCenterX = 0;
		BlockCenterY = 0;
		BlockType = 0;
	}

	public void TestView(){
		System.out.println();
		for(int i=0; i<HEIGHT; i++){
			for(int j=0; j<WIDTH; j++){
				if(cell[i][j] == true){
					System.out.print("＊");
				}else{
					System.out.print("・");
				}
			}
			System.out.println();
		}
	}

// BlockType == 0
// ＊
// ＊＊＊
//
// BlockType == 1
//   ＊
//   ＊
// ＊＊
//
// BlockType == 2
// ＊＊＊
//     ＊
//
// BlockType == 3
// ＊＊
// ＊
// ＊
//

//index 0
	public void createBlolck(int Btype){

		BlockType = Btype;

		if(BlockType == 0){
			BlockCenterX = WIDTH/2 - 1;
			BlockCenterY = 1;
			ComeCell(BlockCenterX, BlockCenterY - 1);
			ComeCell(BlockCenterX, BlockCenterY);
			ComeCell(BlockCenterX + 1, BlockCenterY);
			ComeCell(BlockCenterX + 2, BlockCenterY);
		}else if(BlockType == 1){
			BlockCenterX = WIDTH/2;
			BlockCenterY = 2;
			ComeCell(BlockCenterX - 1, BlockCenterY);
			ComeCell(BlockCenterX, BlockCenterY);
			ComeCell(BlockCenterX, BlockCenterY - 1);
			ComeCell(BlockCenterX, BlockCenterY - 2);
		}else if(BlockType == 2){
			BlockCenterX = WIDTH/2;
			BlockCenterY = 0;
			ComeCell(BlockCenterX - 2, BlockCenterY);
			ComeCell(BlockCenterX - 1, BlockCenterY);
			ComeCell(BlockCenterX, BlockCenterY);
			ComeCell(BlockCenterX, BlockCenterY + 1);
		}else if(BlockType == 3){
			BlockCenterX = WIDTH/2 - 1;
			BlockCenterY = 0;
			ComeCell(BlockCenterX, BlockCenterY);
			ComeCell(BlockCenterX + 1, BlockCenterY);
			ComeCell(BlockCenterX, BlockCenterY + 1);
			ComeCell(BlockCenterX, BlockCenterY + 2);
		}else{

		}
	}

//index 1
	public void moveRight(){

		if(BlockType == 0){
			if(BlockCenterX < WIDTH - 3){
				if(canMoveCell(BlockCenterX + 1, BlockCenterY - 1) && canMoveCell(BlockCenterX + 3,BlockCenterY)){
					Right(BlockCenterX, BlockCenterY - 1);
					Right(BlockCenterX + 2, BlockCenterY);
					Right(BlockCenterX + 1, BlockCenterY);
					Right(BlockCenterX, BlockCenterY);
					BlockCenterX++;
				}
			}
		}else if(BlockType == 1){
			if(BlockCenterX < WIDTH - 1){
				if(canMoveCell(BlockCenterX + 1, BlockCenterY - 2) && canMoveCell(BlockCenterX + 1,BlockCenterY - 2)
						&& canMoveCell(BlockCenterX + 1,BlockCenterY)){
					Right(BlockCenterX, BlockCenterY - 2);
					Right(BlockCenterX, BlockCenterY - 1);
					Right(BlockCenterX, BlockCenterY);
					Right(BlockCenterX - 1, BlockCenterY);
					BlockCenterX++;
				}
			}
		}else if(BlockType == 2){
			if(BlockCenterX < WIDTH - 1){
				if(canMoveCell(BlockCenterX + 1, BlockCenterY - 1) && canMoveCell(BlockCenterX + 1,BlockCenterY)){
					Right(BlockCenterX, BlockCenterY);
					Right(BlockCenterX, BlockCenterY + 1);
					Right(BlockCenterX - 1, BlockCenterY);
					Right(BlockCenterX - 2, BlockCenterY);
					BlockCenterX++;
				}
			}
		}else if(BlockType == 3){
			if(BlockCenterX < WIDTH - 2){
				if(canMoveCell(BlockCenterX + 2, BlockCenterY) && canMoveCell(BlockCenterX + 1, BlockCenterY + 1)
						&& canMoveCell(BlockCenterX + 1, BlockCenterY + 2)){
					Right(BlockCenterX + 1, BlockCenterY);
					Right(BlockCenterX, BlockCenterY);
					Right(BlockCenterX, BlockCenterY  + 1);
					Right(BlockCenterX, BlockCenterY + 2);
					BlockCenterX++;
				}
			}
		}else{

		}
	}

//index 2
	public void moveLeft(){

		if(BlockType == 0){
			if(BlockCenterX > 0){
				if(canMoveCell(BlockCenterX - 1, BlockCenterY - 1) && canMoveCell(BlockCenterX - 1,BlockCenterY)){
					Left(BlockCenterX, BlockCenterY - 1);
					Left(BlockCenterX, BlockCenterY);
					Left(BlockCenterX + 1, BlockCenterY);
					Left(BlockCenterX + 2, BlockCenterY);
					BlockCenterX--;
				}
			}
		}else if(BlockType == 1){
			if(BlockCenterX > 1){
				if(canMoveCell(BlockCenterX - 1, BlockCenterY - 2) && canMoveCell(BlockCenterX - 1,BlockCenterY - 2)
						&& canMoveCell(BlockCenterX - 2, BlockCenterY)){
					Left(BlockCenterX - 1, BlockCenterY);
					Left(BlockCenterX, BlockCenterY - 2);
					Left(BlockCenterX, BlockCenterY - 1);
					Left(BlockCenterX, BlockCenterY);
					BlockCenterX--;
				}
			}
		}else if(BlockType == 2){
			if(BlockCenterX > 2){
				if(canMoveCell(BlockCenterX - 3, BlockCenterY) && canMoveCell(BlockCenterX - 1,BlockCenterY + 1)){
					Left(BlockCenterX - 2, BlockCenterY);
					Left(BlockCenterX - 1, BlockCenterY);
					Left(BlockCenterX, BlockCenterY);
					Left(BlockCenterX, BlockCenterY + 1);
					BlockCenterX--;
				}
			}
		}else if(BlockType == 3){
			if(BlockCenterX > 0){
				if(canMoveCell(BlockCenterX - 1, BlockCenterY) && canMoveCell(BlockCenterX - 1, BlockCenterY + 1)
						&& canMoveCell(BlockCenterX - 1, BlockCenterY + 2)){
					Left(BlockCenterX, BlockCenterY);
					Left(BlockCenterX, BlockCenterY + 1);
					Left(BlockCenterX, BlockCenterY + 2);
					Left(BlockCenterX + 1, BlockCenterY);
					BlockCenterX--;
				}
			}
		}else{

		}
	}

//index 3
	public void down(){

		if(BlockType == 0){
			if(BlockCenterY < HEIGHT - 1){
				if(canMoveCell(BlockCenterX, BlockCenterY + 1) && canMoveCell(BlockCenterX + 1, BlockCenterY + 1)
						&& canMoveCell(BlockCenterX + 2, BlockCenterY + 1)){
					Fall(BlockCenterX + 2, BlockCenterY);
					Fall(BlockCenterX + 1, BlockCenterY);
					Fall(BlockCenterX, BlockCenterY);
					Fall(BlockCenterX, BlockCenterY - 1);
					BlockCenterY++;
				}
			}
		}else if(BlockType == 1){
			if(BlockCenterY < HEIGHT - 1){
				if(canMoveCell(BlockCenterX - 1, BlockCenterY + 1) && canMoveCell(BlockCenterX, BlockCenterY + 1)){
					Fall(BlockCenterX - 1, BlockCenterY);
					Fall(BlockCenterX, BlockCenterY);
					Fall(BlockCenterX, BlockCenterY - 1);
					Fall(BlockCenterX, BlockCenterY - 2);
					BlockCenterY++;
				}
			}
		}else if(BlockType == 2){
			if(BlockCenterY < HEIGHT - 2){
				if(canMoveCell(BlockCenterX - 2, BlockCenterY + 1) && canMoveCell(BlockCenterX - 1, BlockCenterY + 1)
						&& canMoveCell(BlockCenterX, BlockCenterY + 2)){
					Fall(BlockCenterX - 2, BlockCenterY);
					Fall(BlockCenterX - 1, BlockCenterY);
					Fall(BlockCenterX, BlockCenterY);
					Fall(BlockCenterX, BlockCenterY - 1);
					BlockCenterY++;
				}
			}
		}else if(BlockType == 3){
			if(BlockCenterY < HEIGHT - 3){
				if(canMoveCell(BlockCenterX, BlockCenterY + 3) && canMoveCell(BlockCenterX + 1, BlockCenterY + 1)){
					Fall(BlockCenterX, BlockCenterY + 2);
					Fall(BlockCenterX, BlockCenterY + 1);
					Fall(BlockCenterX, BlockCenterY);
					Fall(BlockCenterX + 1, BlockCenterY);
					BlockCenterY++;
				}
			}
		}else{

		}
	}

//index 4
	public void fall(){

		if(BlockType == 0){
			if(BlockCenterY < HEIGHT - 1){
				for(int i = BlockCenterY; i <  HEIGHT; i++){
					if(BlockCenterY < HEIGHT - 1){
						if(canMoveCell(BlockCenterX, BlockCenterY + 1) && canMoveCell(BlockCenterX + 1, BlockCenterY + 1)
								&& canMoveCell(BlockCenterX + 2, BlockCenterY + 1)){
							Fall(BlockCenterX + 2, BlockCenterY);
							Fall(BlockCenterX + 1, BlockCenterY);
							Fall(BlockCenterX, BlockCenterY);
							Fall(BlockCenterX, BlockCenterY - 1);
							BlockCenterY++;
						}
					}
				}
			}
		}else if(BlockType == 1){
			if(BlockCenterY < HEIGHT - 1){
				for(int i = BlockCenterY; i <  HEIGHT - 1; i++){
					if(canMoveCell(BlockCenterX - 1, BlockCenterY + 1) && canMoveCell(BlockCenterX, BlockCenterY + 1)){
						Fall(BlockCenterX - 1, BlockCenterY);
						Fall(BlockCenterX, BlockCenterY);
						Fall(BlockCenterX, BlockCenterY - 1);
						Fall(BlockCenterX, BlockCenterY - 2);
						BlockCenterY++;
					}
				}
			}
		}else if(BlockType == 2){
			if(BlockCenterY < HEIGHT - 2){
				for(int i = BlockCenterY; i <  HEIGHT - 2; i++){
					if(canMoveCell(BlockCenterX - 2, BlockCenterY + 1) && canMoveCell(BlockCenterX - 1, BlockCenterY + 1)
							&& canMoveCell(BlockCenterX, BlockCenterY + 2)){
						Fall(BlockCenterX - 2, BlockCenterY);
						Fall(BlockCenterX - 1, BlockCenterY);
						Fall(BlockCenterX, BlockCenterY);
						Fall(BlockCenterX, BlockCenterY - 1);
						BlockCenterY++;
					}
				}
			}
		}else if(BlockType == 3){
			if(BlockCenterY < HEIGHT - 3){
				for(int i = BlockCenterY; i <  HEIGHT - 3; i++){
					if(canMoveCell(BlockCenterX, BlockCenterY + 3) && canMoveCell(BlockCenterX + 1, BlockCenterY + 1)){
						Fall(BlockCenterX, BlockCenterY + 2);
						Fall(BlockCenterX, BlockCenterY + 1);
						Fall(BlockCenterX, BlockCenterY);
						Fall(BlockCenterX + 1, BlockCenterY);
						BlockCenterY++;
					}
				}
			}
		}else{

		}
	}

//index 5
	public void leftTurn(){
/////////////////////////////////////////////////////////////////////
		if(BlockType == 0){
			if(isCell(BlockCenterX + 1, BlockCenterY - 1)){
				if(BlockCenterY < HEIGHT - 2){
					if(canMoveCell(BlockCenterX, BlockCenterY  + 2) && canMoveCell(BlockCenterX + 1, BlockCenterY + 1)
							&& canMoveCell(BlockCenterX + 1, BlockCenterY + 2)){
						RemoveCell(BlockCenterX, BlockCenterY - 1);
						RemoveCell(BlockCenterX, BlockCenterY);
						RemoveCell(BlockCenterX + 2, BlockCenterY);
						ComeCell(BlockCenterX, BlockCenterY + 2);
						ComeCell(BlockCenterX + 1, BlockCenterY + 1);
						ComeCell(BlockCenterX + 1, BlockCenterY + 2);
						BlockCenterX += 1;
						BlockCenterY += 2;
						BlockType = 1;
					}
				}else if(BlockCenterX > 0){
					if(canMoveCell(BlockCenterX - 1, BlockCenterY) && canMoveCell(BlockCenterX, BlockCenterY - 2)){
						RemoveCell(BlockCenterX + 1, BlockCenterY);
						RemoveCell(BlockCenterX + 2, BlockCenterY);
						ComeCell(BlockCenterX - 1, BlockCenterY);
						ComeCell(BlockCenterX, BlockCenterY - 2);
						BlockType = 1;
					}else if(canMoveCell(BlockCenterX - 1, BlockCenterY + 1) && canMoveCell(BlockCenterX, BlockCenterY + 1)){
						RemoveCell(BlockCenterX + 1, BlockCenterY);
						RemoveCell(BlockCenterX + 2, BlockCenterY);
						ComeCell(BlockCenterX - 1, BlockCenterY + 1);
						ComeCell(BlockCenterX, BlockCenterY + 1);
						BlockCenterY += 1;
						BlockType = 1;
					}
				}
			}else if(BlockCenterY == 1){
				if(canMoveCell(BlockCenterX, BlockCenterY + 1) && canMoveCell(BlockCenterX + 1, BlockCenterY + 1)
						&& canMoveCell(BlockCenterX + 1, BlockCenterY - 1)){
					RemoveCell(BlockCenterX, BlockCenterY - 1);
					RemoveCell(BlockCenterX, BlockCenterY);
					RemoveCell(BlockCenterX + 2, BlockCenterY);
					ComeCell(BlockCenterX, BlockCenterY + 1);
					ComeCell(BlockCenterX + 1, BlockCenterY + 1);
					ComeCell(BlockCenterX + 1, BlockCenterY - 1);
					BlockCenterX += 1;
					BlockCenterY += 1;
					BlockType = 1;
				}else if(canMoveCell(BlockCenterX - 1, BlockCenterY + 1) && canMoveCell(BlockCenterX, BlockCenterY + 1)){
					RemoveCell(BlockCenterX + 1, BlockCenterY);
					RemoveCell(BlockCenterX + 2, BlockCenterY);
					ComeCell(BlockCenterX - 1, BlockCenterY + 1);
					ComeCell(BlockCenterX, BlockCenterY + 1);
					BlockCenterY += 1;
					BlockType = 1;
				}
			}else if(isCell(BlockCenterX + 1, BlockCenterY - 2)){
				if(BlockCenterY < HEIGHT - 1){
					if(canMoveCell(BlockCenterX, BlockCenterY + 1) && canMoveCell(BlockCenterX + 1, BlockCenterY + 1)
							&& canMoveCell(BlockCenterX + 1, BlockCenterY - 1)){
						RemoveCell(BlockCenterX, BlockCenterY - 1);
						RemoveCell(BlockCenterX, BlockCenterY);
						RemoveCell(BlockCenterX + 2, BlockCenterY);
						ComeCell(BlockCenterX, BlockCenterY + 1);
						ComeCell(BlockCenterX + 1, BlockCenterY + 1);
						ComeCell(BlockCenterX + 1, BlockCenterY - 1);
						BlockCenterX += 1;
						BlockCenterY += 1;
						BlockType = 1;
					}else if(BlockCenterX > 0){
						if(canMoveCell(BlockCenterX - 1, BlockCenterY) && canMoveCell(BlockCenterX, BlockCenterY - 2)){
							RemoveCell(BlockCenterX + 1, BlockCenterY);
							RemoveCell(BlockCenterX + 2, BlockCenterY);
							ComeCell(BlockCenterX - 1, BlockCenterY);
							ComeCell(BlockCenterX, BlockCenterY - 2);
							BlockType = 1;
						}else if(canMoveCell(BlockCenterX - 1, BlockCenterY + 1) && canMoveCell(BlockCenterX, BlockCenterY + 1)){
							RemoveCell(BlockCenterX + 1, BlockCenterY);
							RemoveCell(BlockCenterX + 2, BlockCenterY);
							ComeCell(BlockCenterX - 1, BlockCenterY + 1);
							ComeCell(BlockCenterX, BlockCenterY + 1);
							BlockCenterY += 1;
							BlockType = 1;
						}
					}
				}else{
					if(BlockCenterX > 0){
						if(canMoveCell(BlockCenterX - 1, BlockCenterY) && canMoveCell(BlockCenterX, BlockCenterY - 2)){
							RemoveCell(BlockCenterX + 1, BlockCenterY);
							RemoveCell(BlockCenterX + 2, BlockCenterY);
							ComeCell(BlockCenterX - 1, BlockCenterY);
							ComeCell(BlockCenterX, BlockCenterY - 2);
							BlockType = 1;
						}
					}
				}
			}else{
				if(canMoveCell(BlockCenterX + 1, BlockCenterY - 1) && canMoveCell(BlockCenterX + 1, BlockCenterY - 2)){
					RemoveCell(BlockCenterX, BlockCenterY - 1);
					RemoveCell(BlockCenterX + 2, BlockCenterY);
					ComeCell(BlockCenterX + 1, BlockCenterY - 2);
					ComeCell(BlockCenterX + 1, BlockCenterY - 1);
					BlockCenterX += 1;
					BlockType = 1;
				}
			}
//////////////////////////////////////////////////////////////////////////////
		}else if(BlockType == 1){
			if(isCell(BlockCenterX - 1, BlockCenterY - 1)){
				if(BlockCenterX < WIDTH - 2){
					if(canMoveCell(BlockCenterX + 1, BlockCenterY - 1) && canMoveCell(BlockCenterX + 2, BlockCenterY - 1)
							&& canMoveCell(BlockCenterX + 2, BlockCenterY)){
						RemoveCell(BlockCenterX, BlockCenterY - 2);
						RemoveCell(BlockCenterX - 1, BlockCenterY);
						RemoveCell(BlockCenterX, BlockCenterY);
						ComeCell(BlockCenterX + 1, BlockCenterY - 1);
						ComeCell(BlockCenterX + 2, BlockCenterY - 1);
						ComeCell(BlockCenterX + 2, BlockCenterY);
						BlockCenterX += 2;
						BlockCenterY -= 1;
						BlockType = 2;
					}
				}else if(BlockCenterY < HEIGHT - 1){
					if(canMoveCell(BlockCenterX - 2, BlockCenterY) && canMoveCell(BlockCenterX, BlockCenterY + 1)){
						RemoveCell(BlockCenterX, BlockCenterY - 2);
						RemoveCell(BlockCenterX, BlockCenterY - 1);
						ComeCell(BlockCenterX - 2, BlockCenterY);
						ComeCell(BlockCenterX, BlockCenterY + 1);
						BlockType = 2;
					}else if(canMoveCell(BlockCenterX + 1, BlockCenterY) && canMoveCell(BlockCenterX + 1, BlockCenterY + 1)){
						RemoveCell(BlockCenterX, BlockCenterY - 2);
						RemoveCell(BlockCenterX, BlockCenterY - 1);
						ComeCell(BlockCenterX + 1, BlockCenterY);
						ComeCell(BlockCenterX + 1, BlockCenterY + 1);
						BlockCenterX += 1;
						BlockType = 2;
					}
				}
			}else if(BlockCenterX == 1){
				if(canMoveCell(BlockCenterX - 1, BlockCenterY - 1) && canMoveCell(BlockCenterX + 1, BlockCenterY - 1)
						&& canMoveCell(BlockCenterX + 1, BlockCenterY)){
					RemoveCell(BlockCenterX - 1, BlockCenterY);
					RemoveCell(BlockCenterX, BlockCenterY);
					RemoveCell(BlockCenterX, BlockCenterY - 2);
					ComeCell(BlockCenterX - 1, BlockCenterY - 1);
					ComeCell(BlockCenterX + 1, BlockCenterY - 1);
					ComeCell(BlockCenterX + 1, BlockCenterY);
					BlockCenterX += 1;
					BlockCenterY -= 1;
					BlockType = 2;
				}else if(canMoveCell(BlockCenterX + 1, BlockCenterY) && canMoveCell(BlockCenterX + 1, BlockCenterY + 1)){
					RemoveCell(BlockCenterX, BlockCenterY - 2);
					RemoveCell(BlockCenterX, BlockCenterY - 1);
					ComeCell(BlockCenterX + 1, BlockCenterY);
					ComeCell(BlockCenterX + 1, BlockCenterY + 1);
					BlockCenterX += 1;
					BlockType = 2;
				}
			}else if(isCell(BlockCenterX - 2, BlockCenterY - 1)){
				if(BlockCenterX < WIDTH - 1){
					if(canMoveCell(BlockCenterX - 1, BlockCenterY - 1) && canMoveCell(BlockCenterX + 1, BlockCenterY - 1)
							&& canMoveCell(BlockCenterX + 1, BlockCenterY)){
						RemoveCell(BlockCenterX - 1, BlockCenterY);
						RemoveCell(BlockCenterX, BlockCenterY);
						RemoveCell(BlockCenterX, BlockCenterY - 2);
						ComeCell(BlockCenterX - 1, BlockCenterY - 1);
						ComeCell(BlockCenterX + 1, BlockCenterY - 1);
						ComeCell(BlockCenterX + 1, BlockCenterY);
						BlockCenterX += 1;
						BlockCenterY -= 1;
						BlockType = 2;
					}else if(BlockCenterY < HEIGHT - 1){
						if(canMoveCell(BlockCenterX - 2, BlockCenterY) && canMoveCell(BlockCenterX, BlockCenterY + 1)){
							RemoveCell(BlockCenterX, BlockCenterY - 2);
							RemoveCell(BlockCenterX, BlockCenterY - 1);
							ComeCell(BlockCenterX - 2, BlockCenterY);
							ComeCell(BlockCenterX, BlockCenterY + 1);
							BlockType = 2;
						}else if(canMoveCell(BlockCenterX + 1, BlockCenterY) && canMoveCell(BlockCenterX + 1, BlockCenterY + 1)){
							RemoveCell(BlockCenterX, BlockCenterY - 2);
							RemoveCell(BlockCenterX, BlockCenterY - 1);
							ComeCell(BlockCenterX + 1, BlockCenterY);
							ComeCell(BlockCenterX + 1, BlockCenterY + 1);
							BlockCenterX += 1;
							BlockType = 2;
						}
					}
				}else{
					if(BlockCenterY < HEIGHT - 1){
						if(canMoveCell(BlockCenterX - 2, BlockCenterY) && canMoveCell(BlockCenterX, BlockCenterY + 1)){
							RemoveCell(BlockCenterX, BlockCenterY - 2);
							RemoveCell(BlockCenterX, BlockCenterY - 1);
							ComeCell(BlockCenterX - 2, BlockCenterY);
							ComeCell(BlockCenterX, BlockCenterY + 1);
							BlockType = 2;
						}
					}
				}
			}else{
				if(canMoveCell(BlockCenterX - 1, BlockCenterY - 1) && canMoveCell(BlockCenterX - 2, BlockCenterY - 1)){
					RemoveCell(BlockCenterX - 1, BlockCenterY);
					RemoveCell(BlockCenterX, BlockCenterY - 2);
					ComeCell(BlockCenterX - 2, BlockCenterY - 1);
					ComeCell(BlockCenterX - 1, BlockCenterY - 1);
					BlockCenterY -= 1;
					BlockType = 2;
				}
			}
//////////////////////////////////////////////////////////////////////////////////////////
		}else if(BlockType == 2){

			if(isCell(BlockCenterX - 1, BlockCenterY + 1)){
				if(BlockCenterY > 1){
					if(canMoveCell(BlockCenterX - 1, BlockCenterY - 2) && canMoveCell(BlockCenterX - 1, BlockCenterY - 1)
							&& canMoveCell(BlockCenterX, BlockCenterY - 2)){
						RemoveCell(BlockCenterX - 2, BlockCenterY);
						RemoveCell(BlockCenterX, BlockCenterY);
						RemoveCell(BlockCenterX, BlockCenterY + 1);
						ComeCell(BlockCenterX - 1, BlockCenterY - 1);
						ComeCell(BlockCenterX - 1, BlockCenterY - 2);
						ComeCell(BlockCenterX, BlockCenterY - 2);
						BlockCenterX -= 1;
						BlockCenterY -= 2;
						BlockType = 3;
					}
				}else if(BlockCenterX < WIDTH - 1){
					if(canMoveCell(BlockCenterX, BlockCenterY + 2) && canMoveCell(BlockCenterX + 1, BlockCenterY)){
						RemoveCell(BlockCenterX - 2, BlockCenterY);
						RemoveCell(BlockCenterX - 1, BlockCenterY);
						ComeCell(BlockCenterX, BlockCenterY + 2);
						ComeCell(BlockCenterX + 1, BlockCenterY);
						BlockType = 3;
					}else if(canMoveCell(BlockCenterX, BlockCenterY - 1) && canMoveCell(BlockCenterX + 1, BlockCenterY - 1)){
						RemoveCell(BlockCenterX - 2, BlockCenterY);
						RemoveCell(BlockCenterX - 1, BlockCenterY);
						ComeCell(BlockCenterX, BlockCenterY - 1);
						ComeCell(BlockCenterX + 1, BlockCenterY - 1);
						BlockCenterY -= 1;
						BlockType = 3;
					}
				}
			}else if(BlockCenterY == HEIGHT - 2){
				if(canMoveCell(BlockCenterX - 1, BlockCenterY + 1) && canMoveCell(BlockCenterX - 1, BlockCenterY - 1)
						&& canMoveCell(BlockCenterX, BlockCenterY  -1)){
					RemoveCell(BlockCenterX - 2, BlockCenterY);
					RemoveCell(BlockCenterX, BlockCenterY);
					RemoveCell(BlockCenterX, BlockCenterY + 1);
					ComeCell(BlockCenterX - 1, BlockCenterY - 1);
					ComeCell(BlockCenterX - 1, BlockCenterY + 1);
					ComeCell(BlockCenterX, BlockCenterY - 1);
					BlockCenterX -= 1;
					BlockCenterY -= 1;
					BlockType = 3;
				}else if(canMoveCell(BlockCenterX, BlockCenterY - 1) && canMoveCell(BlockCenterX + 1, BlockCenterY - 1)){
					RemoveCell(BlockCenterX - 2, BlockCenterY);
					RemoveCell(BlockCenterX - 1, BlockCenterY);
					ComeCell(BlockCenterX, BlockCenterY - 1);
					ComeCell(BlockCenterX + 1, BlockCenterY - 1);
					BlockCenterY -= 1;
					BlockType = 3;
				}
			}else if(isCell(BlockCenterX - 1, BlockCenterY + 2)){
				if(BlockCenterY > 0){
					if(canMoveCell(BlockCenterX - 1, BlockCenterY + 1) && canMoveCell(BlockCenterX - 1, BlockCenterY - 1)
							&& canMoveCell(BlockCenterX, BlockCenterY  -1)){
						RemoveCell(BlockCenterX - 2, BlockCenterY);
						RemoveCell(BlockCenterX, BlockCenterY);
						RemoveCell(BlockCenterX, BlockCenterY + 1);
						ComeCell(BlockCenterX - 1, BlockCenterY - 1);
						ComeCell(BlockCenterX - 1, BlockCenterY + 1);
						ComeCell(BlockCenterX, BlockCenterY - 1);
						BlockCenterX -= 1;
						BlockCenterY -= 1;
						BlockType = 3;
					}else if(BlockCenterX < WIDTH - 1){
						if(canMoveCell(BlockCenterX, BlockCenterY + 2) && canMoveCell(BlockCenterX + 1, BlockCenterY)){
							RemoveCell(BlockCenterX - 2, BlockCenterY);
							RemoveCell(BlockCenterX - 1, BlockCenterY);
							ComeCell(BlockCenterX, BlockCenterY + 2);
							ComeCell(BlockCenterX + 1, BlockCenterY);
							BlockType = 3;
						}else if(canMoveCell(BlockCenterX, BlockCenterY - 1) && canMoveCell(BlockCenterX + 1, BlockCenterY - 1)){
							RemoveCell(BlockCenterX - 2, BlockCenterY);
							RemoveCell(BlockCenterX - 1, BlockCenterY);
							ComeCell(BlockCenterX, BlockCenterY - 1);
							ComeCell(BlockCenterX + 1, BlockCenterY - 1);
							BlockCenterY -= 1;
							BlockType = 3;
						}
					}
				}else{
					if(BlockCenterX < WIDTH - 1){
						if(canMoveCell(BlockCenterX, BlockCenterY + 2) && canMoveCell(BlockCenterX + 1, BlockCenterY)){
							RemoveCell(BlockCenterX - 2, BlockCenterY);
							RemoveCell(BlockCenterX - 1, BlockCenterY);
							ComeCell(BlockCenterX, BlockCenterY + 2);
							ComeCell(BlockCenterX + 1, BlockCenterY);
							BlockType = 3;
						}
					}
				}
			}else{
				if(canMoveCell(BlockCenterX - 1, BlockCenterY + 1) && canMoveCell(BlockCenterX - 1, BlockCenterY + 2)){
					RemoveCell(BlockCenterX - 2, BlockCenterY);
					RemoveCell(BlockCenterX, BlockCenterY + 1);
					ComeCell(BlockCenterX - 1, BlockCenterY + 1);
					ComeCell(BlockCenterX - 1, BlockCenterY + 2);
					BlockCenterX -= 1;
					BlockType = 3;
				}
			}
///////////////////////////////////////////////////////////////////////
		}else if(BlockType == 3){
			if(isCell(BlockCenterX + 1, BlockCenterY + 1)){
				if(BlockCenterX > 1){
					if(canMoveCell(BlockCenterX - 2, BlockCenterY) && canMoveCell(BlockCenterX - 2, BlockCenterY + 1)
							&& canMoveCell(BlockCenterX - 1, BlockCenterY + 1)){
						RemoveCell(BlockCenterX, BlockCenterY);
						RemoveCell(BlockCenterX + 1, BlockCenterY);
						RemoveCell(BlockCenterX, BlockCenterY + 2);
						ComeCell(BlockCenterX - 2, BlockCenterY);
						ComeCell(BlockCenterX - 2, BlockCenterY + 1);
						ComeCell(BlockCenterX - 1, BlockCenterY + 1);
						BlockCenterX -= 2;
						BlockCenterY += 1;
						BlockType = 0;
					}
				}else if(BlockCenterY > 0){
					if(canMoveCell(BlockCenterX, BlockCenterY - 1) && canMoveCell(BlockCenterX + 2, BlockCenterY)){
						RemoveCell(BlockCenterX, BlockCenterY + 1);
						RemoveCell(BlockCenterX, BlockCenterY + 2);
						ComeCell(BlockCenterX, BlockCenterY - 1);
						ComeCell(BlockCenterX + 2, BlockCenterY);
						BlockType = 0;
					}else if(canMoveCell(BlockCenterX - 1, BlockCenterY - 1) && canMoveCell(BlockCenterX - 1, BlockCenterY)){
						RemoveCell(BlockCenterX, BlockCenterY + 1);
						RemoveCell(BlockCenterX, BlockCenterY + 2);
						ComeCell(BlockCenterX - 1, BlockCenterY);
						ComeCell(BlockCenterX - 1, BlockCenterY - 1);
						BlockCenterX -= 1;
						BlockType = 0;
					}
				}
			}else if(BlockCenterX == WIDTH - 2){
				if(canMoveCell(BlockCenterX - 1, BlockCenterY) && canMoveCell(BlockCenterX - 1, BlockCenterY + 1)
						&& canMoveCell(BlockCenterX + 1, BlockCenterY + 1)){
					RemoveCell(BlockCenterX, BlockCenterY);
					RemoveCell(BlockCenterX, BlockCenterY + 2);
					RemoveCell(BlockCenterX + 1, BlockCenterY);
					ComeCell(BlockCenterX - 1, BlockCenterY);
					ComeCell(BlockCenterX - 1, BlockCenterY + 1);
					ComeCell(BlockCenterX + 1, BlockCenterY + 1);
					BlockCenterX -= 1;
					BlockCenterY += 1;
					BlockType = 0;
				}else if(canMoveCell(BlockCenterX - 1, BlockCenterY - 1) && canMoveCell(BlockCenterX - 1, BlockCenterY)){
					RemoveCell(BlockCenterX, BlockCenterY + 1);
					RemoveCell(BlockCenterX, BlockCenterY + 2);
					ComeCell(BlockCenterX - 1, BlockCenterY);
					ComeCell(BlockCenterX - 1, BlockCenterY - 1);
					BlockCenterX -= 1;
					BlockType = 0;
				}
			}else if(isCell(BlockCenterX + 2, BlockCenterY + 1)){
				if(BlockCenterX > 0){
					if(canMoveCell(BlockCenterX - 1, BlockCenterY) && canMoveCell(BlockCenterX - 1, BlockCenterY + 1)
							&& canMoveCell(BlockCenterX + 1, BlockCenterY + 1)){
						RemoveCell(BlockCenterX, BlockCenterY);
						RemoveCell(BlockCenterX, BlockCenterY + 2);
						RemoveCell(BlockCenterX + 1, BlockCenterY);
						ComeCell(BlockCenterX - 1, BlockCenterY);
						ComeCell(BlockCenterX - 1, BlockCenterY + 1);
						ComeCell(BlockCenterX + 1, BlockCenterY + 1);
						BlockCenterX -= 1;
						BlockCenterY += 1;
						BlockType = 0;
					}else if(BlockCenterY > 0){
						if(canMoveCell(BlockCenterX, BlockCenterY - 1) && canMoveCell(BlockCenterX + 2, BlockCenterY)){
							RemoveCell(BlockCenterX, BlockCenterY + 1);
							RemoveCell(BlockCenterX, BlockCenterY + 2);
							ComeCell(BlockCenterX, BlockCenterY - 1);
							ComeCell(BlockCenterX + 2, BlockCenterY);
							BlockType = 0;
						}else if(canMoveCell(BlockCenterX - 1, BlockCenterY - 1) && canMoveCell(BlockCenterX - 1, BlockCenterY)){
							RemoveCell(BlockCenterX, BlockCenterY + 1);
							RemoveCell(BlockCenterX, BlockCenterY + 2);
							ComeCell(BlockCenterX - 1, BlockCenterY);
							ComeCell(BlockCenterX - 1, BlockCenterY - 1);
							BlockCenterX -= 1;
							BlockType = 0;
						}
					}
				}else{
					if(BlockCenterY > 0){
						if(canMoveCell(BlockCenterX, BlockCenterY - 1) && canMoveCell(BlockCenterX + 2, BlockCenterY)){
							RemoveCell(BlockCenterX, BlockCenterY + 1);
							RemoveCell(BlockCenterX, BlockCenterY + 2);
							ComeCell(BlockCenterX, BlockCenterY - 1);
							ComeCell(BlockCenterX + 2, BlockCenterY);
							BlockType = 0;
						}
					}
				}
			}else{
				if(canMoveCell(BlockCenterX + 1, BlockCenterY + 1) && canMoveCell(BlockCenterX + 2, BlockCenterY + 1)){
					RemoveCell(BlockCenterX + 1, BlockCenterY);
					RemoveCell(BlockCenterX, BlockCenterY + 2);
					ComeCell(BlockCenterX + 1, BlockCenterY + 1);
					ComeCell(BlockCenterX + 2, BlockCenterY + 1);
					BlockCenterY += 1;
					BlockType = 0;
				}
			}
		}else{

		}
	}


	//index 6
	public void rightTurn(){
//////////////////////////////////////////////////////////////////////
		if(BlockType == 0){
			if(BlockCenterY == HEIGHT - 1){
				if(isCell(BlockCenterX, BlockCenterY - 2)){
					if(canMoveCell(BlockCenterX + 1, BlockCenterY - 1) && canMoveCell(BlockCenterX + 1, BlockCenterY - 2)
							&& canMoveCell(BlockCenterX + 2, BlockCenterY - 2)){
						if(canMoveCell(BlockCenterX + 1, BlockCenterY - 2) && canMoveCell(BlockCenterX + 2, BlockCenterY - 2)
								&& canMoveCell(BlockCenterX + 1, BlockCenterY - 1)){
							RemoveCell(BlockCenterX, BlockCenterY - 1);
							RemoveCell(BlockCenterX, BlockCenterY);
							RemoveCell(BlockCenterX + 2, BlockCenterY);
							ComeCell(BlockCenterX + 2, BlockCenterY - 2);
							ComeCell(BlockCenterX + 1, BlockCenterY - 2);
							ComeCell(BlockCenterX + 1, BlockCenterY - 1);
							BlockCenterX += 1;
							BlockCenterY -= 2;
							BlockType = 3;
						}
					}
				}else if(isCell(BlockCenterX, BlockCenterY - 2)){
					if(BlockCenterX > 0){
						if(canMoveCell(BlockCenterX - 1, BlockCenterY - 1) && canMoveCell(BlockCenterX - 1, BlockCenterY)
								&& canMoveCell(BlockCenterX - 1, BlockCenterY + 1)){
							RemoveCell(BlockCenterX, BlockCenterY);
							RemoveCell(BlockCenterX + 1, BlockCenterY);
							RemoveCell(BlockCenterX + 2, BlockCenterY);
							ComeCell(BlockCenterX - 1, BlockCenterY - 1);
							ComeCell(BlockCenterX - 1, BlockCenterY);
							ComeCell(BlockCenterX - 1, BlockCenterY + 1);
							BlockCenterX -= 1;
							BlockCenterY -= 1;
							BlockType = 3;
						}
					}
				}else{
					if(canMoveCell(BlockCenterX, BlockCenterY - 2) && canMoveCell(BlockCenterX + 1, BlockCenterY - 2)){
						RemoveCell(BlockCenterX + 1, BlockCenterY);
						RemoveCell(BlockCenterX + 2, BlockCenterY);
						ComeCell(BlockCenterX + 1, BlockCenterY - 2);
						ComeCell(BlockCenterX, BlockCenterY - 2);
						BlockCenterY -= 2;
						BlockType = 3;
					}
				}
			}else if(BlockCenterY == HEIGHT - 2){

			}else if(BlockCenterY == 1){

			}else{

			}
///////////////////////////////////////////////////////////////////////////
			if(canMoveCell(BlockCenterX + 1, BlockCenterY - 1) && canMoveCell(BlockCenterX, BlockCenterY + 1)){
				RemoveCell(BlockCenterX + 1, BlockCenterY);
				RemoveCell(BlockCenterX + 2, BlockCenterY);
				ComeCell(BlockCenterX + 1, BlockCenterY - 1);
				ComeCell(BlockCenterX, BlockCenterY + 1);
				BlockCenterY -= 1;
				BlockType = 3;
			}
			if(canMoveCell(BlockCenterX, BlockCenterY - 2) && canMoveCell(BlockCenterX + 1, BlockCenterY - 2)){
				RemoveCell(BlockCenterX + 1, BlockCenterY);
				RemoveCell(BlockCenterX + 2, BlockCenterY);
				ComeCell(BlockCenterX + 1, BlockCenterY - 2);
				ComeCell(BlockCenterX, BlockCenterY - 2);
				BlockCenterY -= 2;
				BlockType = 3;
			}
			if(canMoveCell(BlockCenterX + 1, BlockCenterY - 2) && canMoveCell(BlockCenterX + 2, BlockCenterY - 2)
					&& canMoveCell(BlockCenterX + 1, BlockCenterY - 1)){
				RemoveCell(BlockCenterX, BlockCenterY - 1);
				RemoveCell(BlockCenterX, BlockCenterY);
				RemoveCell(BlockCenterX + 2, BlockCenterY);
				ComeCell(BlockCenterX + 2, BlockCenterY - 2);
				ComeCell(BlockCenterX + 1, BlockCenterY - 2);
				ComeCell(BlockCenterX + 1, BlockCenterY - 1);
				BlockCenterX += 1;
				BlockCenterY -= 2;
				BlockType = 3;
			}
			if(canMoveCell(BlockCenterX, BlockCenterY + 1) && canMoveCell(BlockCenterX, BlockCenterY + 2)){
				RemoveCell(BlockCenterX, BlockCenterY - 1);
				RemoveCell(BlockCenterX + 2, BlockCenterY);
				ComeCell(BlockCenterX, BlockCenterY + 1);
				ComeCell(BlockCenterX, BlockCenterY + 2);
				BlockType = 3;
			}
			if(canMoveCell(BlockCenterX - 1, BlockCenterY - 1) && canMoveCell(BlockCenterX - 1, BlockCenterY)
					&& canMoveCell(BlockCenterX - 1, BlockCenterY + 1)){
				RemoveCell(BlockCenterX, BlockCenterY);
				RemoveCell(BlockCenterX + 1, BlockCenterY);
				RemoveCell(BlockCenterX + 2, BlockCenterY);
				ComeCell(BlockCenterX - 1, BlockCenterY - 1);
				ComeCell(BlockCenterX - 1, BlockCenterY);
				ComeCell(BlockCenterX - 1, BlockCenterY + 1);
				BlockCenterX -= 1;
				BlockCenterY -= 1;
				BlockType = 3;
			}
			if(canMoveCell(BlockCenterX - 1, BlockCenterY - 2) && canMoveCell(BlockCenterX, BlockCenterY - 2)
					&& canMoveCell(BlockCenterX - 1, BlockCenterY - 1) && canMoveCell(BlockCenterX - 1, BlockCenterY)){
				RemoveCell(BlockCenterX, BlockCenterY - 1);
				RemoveCell(BlockCenterX, BlockCenterY);
				RemoveCell(BlockCenterX + 1, BlockCenterY);
				RemoveCell(BlockCenterX + 2, BlockCenterY);
				ComeCell(BlockCenterX - 1, BlockCenterY - 2);
				ComeCell(BlockCenterX, BlockCenterY - 2);
				ComeCell(BlockCenterX - 1, BlockCenterY - 1);
				ComeCell(BlockCenterX - 1, BlockCenterY);
				BlockCenterX -= 1;
				BlockCenterY -= 2;
				BlockType = 3;
			}

//////////////////////////////////////////////////////////////////////
		}else if(BlockType == 1){
			if( BlockCenterX == WIDTH - 1){
				if(canMoveCell(BlockCenterX - 2, BlockCenterY) && canMoveCell(BlockCenterX - 2, BlockCenterY - 1)){
					RemoveCell(BlockCenterX, BlockCenterY - 1);
					RemoveCell(BlockCenterX, BlockCenterY - 2);
					ComeCell(BlockCenterX - 2, BlockCenterY);
					ComeCell(BlockCenterX - 2, BlockCenterY - 1);
					BlockCenterX -= 2;
					BlockType = 0;
				}
			}else if(isCell(BlockCenterX + 1, BlockCenterY) && BlockCenterX > 1){
				if(canMoveCell(BlockCenterX - 2, BlockCenterY) && canMoveCell(BlockCenterX - 2, BlockCenterY - 1)){
					RemoveCell(BlockCenterX, BlockCenterY - 1);
					RemoveCell(BlockCenterX, BlockCenterY - 2);
					ComeCell(BlockCenterX - 2, BlockCenterY);
					ComeCell(BlockCenterX - 2, BlockCenterY - 1);
					BlockCenterX -= 2;
					BlockType = 0;
				}
			}else if(BlockCenterX == WIDTH - 2){
				if(canMoveCell(BlockCenterX - 1, BlockCenterY - 1) && canMoveCell(BlockCenterX + 1, BlockCenterY)){
					RemoveCell(BlockCenterX, BlockCenterY - 1);
					RemoveCell(BlockCenterX, BlockCenterY - 2);
					ComeCell(BlockCenterX - 1, BlockCenterY - 1);
					ComeCell(BlockCenterX + 1, BlockCenterY);
					BlockCenterX -= 1;
					BlockType = 0;
				}
			}else if(isCell(BlockCenterX + 2, BlockCenterY)){
				if(canMoveCell(BlockCenterX - 1, BlockCenterY - 1) && canMoveCell(BlockCenterX + 1, BlockCenterY)){
					RemoveCell(BlockCenterX, BlockCenterY - 1);
					RemoveCell(BlockCenterX, BlockCenterY - 2);
					ComeCell(BlockCenterX - 1, BlockCenterY - 1);
					ComeCell(BlockCenterX + 1, BlockCenterY);
					BlockCenterX -= 1;
					BlockType = 0;
				}
			}else{
				if(isCell(BlockCenterX + 1, BlockCenterY) && isCell(BlockCenterX + 2, BlockCenterY)){
					RemoveCell(BlockCenterX - 1, BlockCenterY);
					RemoveCell(BlockCenterX, BlockCenterY - 2);
					ComeCell(BlockCenterX + 1, BlockCenterY);
					ComeCell(BlockCenterX + 2, BlockCenterY);
					BlockType = 0;
				}
			}
		}else if(BlockType == 2){

		}else if(BlockType == 3){

		}else{

		}
	}

	// BlockType == 0
	// ＊
	// ＊＊＊
	//
	// BlockType == 1
	//   ＊
	//   ＊
	// ＊＊
	//
	// BlockType == 2
	// ＊＊＊
	//	   ＊
	//
	// BlockType == 3
	// ＊＊
	// ＊
	// ＊
	//


//cellになにもないときtrueを返す
	public Boolean canMoveCell(int x, int y){
		if(cell[y][x] == true){
			return false;
		}else{
			return true;
		}
	}
//cellにブロックがあるときtrueを返す
	public Boolean isCell(int x, int y){
		if(cell[y][x] == true){
			return true;
		}else{
			return false;
		}
	}

//１つ１つのセルの動き
	public void ComeCell(int x, int y){
		cell[y][x] = true;
	}
	public void RemoveCell(int x, int y){
		cell[y][x] = false;
	}
	public void Fall(int x, int y){
		if(y < HEIGHT){
			if(canMoveCell(x, y + 1)){
				ComeCell(x, y + 1);
				RemoveCell(x, y);
			}
		}
	}
	public void Right(int x, int y){
		if(x < WIDTH){
			if(canMoveCell(x + 1, y) ){
				ComeCell(x + 1, y);
				RemoveCell(x, y);
			}
		}
	}
	public void Left(int x, int y){
		if(x > 0){
			if(canMoveCell(x - 1, y) ){
				ComeCell(x- 1, y);
				RemoveCell(x, y);
			}
		}
	}

	//ブロックごとに移動
	//回転

	//下に何もなかったら落としていく
	//下まで落とす
	//下まで達したら一列あるところを消す
	//落とす
	//そして次のブロック


}