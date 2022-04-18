import java.util.Scanner;

public class Main {

    public static boolean checkRowCol(char c1, char c2, char c3){
        return ((c1!=' ')&&(c1==c2)&&(c2==c3));
    }
    
    public static boolean checkRowsForWin(char[][] arr){
    for (int i = 0; i<3; i ++){
    if (checkRowCol(arr[i][0], arr[i][1], arr[i][2])== true){
    return true;}
    }return false;
    }
    
    public static boolean checkColumnForWin(char [][] arr){
    for (int i = 0; i<3; i ++){
    if (checkRowCol(arr[0][i], arr[1][i], arr[2][i])== true){
    return true;}
    }return false;
    }
     
    public static boolean checkDiagonalForWin(char [][] arr){
    boolean negativeDirection = checkRowCol(arr[0][0],arr[1][1],arr[2][2]);
    boolean positiveDirection = checkRowCol(arr[0][2],arr[1][1],arr[2][0]);
    
    if(negativeDirection == true || positiveDirection == true){
    return true;
    }else {
    return false;
        }
    }
    
    public static boolean checkForWin(char [][] arr){
    return (checkRowsForWin(arr)||checkColumnForWin(arr)||checkDiagonalForWin(arr));
    }
    
    public static boolean boardFull(char[][] arr){
    for(int i = 0; i<3; i++){
    for(int j = 0; j<3; j++){
    if (arr[i][j] == ' '){
    return false;}
          }
        }
    return true;
    }
    
    public static char playerHasWon(char [][] arr){
    for(int i = 0; i<3; i++){
    if(arr[i][0] == arr[i][1]&&arr[i][1] == arr[i][2]&& arr[i][0] !='_'){
    return arr[i][0];
        }
    }
    for(int j = 0; j<3; j++){
    if(arr[0][j] == arr[1][j]&&arr[1][j] == arr[2][j]&& arr[0][j] !='_'){
    return arr[0][j];
        }
    }
    
    if(arr[0][0] == arr[1][1]&&arr[1][1] == arr[2][2]&& arr[0][0] !='_'){
    return arr[1][1];
        }
    if(arr[2][0] == arr[1][1]&&arr[1][1] == arr[0][2]&& arr[2][0] !='_'){
    return arr[1][1];
        }
    return ' ';
    }
    
    public static boolean hasOnlyDigit(String string){
    char tmp;
    for(int i=0; i < string.length(); i++){
    tmp = string.charAt(i);
    if(Character.isDigit(tmp) == false){
    return false;
            }
        }
    return true;
    }
    
    public static void printBoard(char [][] arr){
        System.out.println("---------");
        for(int i = 0; i<3; i++){
            System.out.print("| ");
    for(int j = 0; j<3; j++){
        System.out.print(arr[i][j] + " ");
    }
        System.out.print("|");
        System.out.println();
        }
        System.out.println("---------");
    }
    
    public static char [][] initializedBoard(char [][] arr){
    for(int i = 0; i<3; i++){
    for(int j = 0; j<3; j++){
    arr[i][j]=' ';}
    }
    return arr;
    }
    
    public static char changePlayer(char currentPlayerMark){
    if(currentPlayerMark == 'X'){
    return currentPlayerMark = 'O';
    } else {
    return currentPlayerMark = 'X';}
    }
            
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        char[][] arr = new char[3][3];
        arr = initializedBoard(arr);
        printBoard(arr);
        char currentPlayerMark = 'X';
        
        boolean complete = true;
        boolean flag = true;
        
        do{
        System.out.println("Enter the coordinates: ");
        String userInput = sc.nextLine();
        String intStr = userInput.replace(" ", "");
        if (hasOnlyDigit(intStr) == false){
        System.out.println("You should enter numbers!");
        
        flag = true;}
        else {
        String[] temp = userInput.split(" ");
        int x = Integer.parseInt(temp[0]);
        int y = Integer.parseInt(temp[1]);
        
        if (x>3 || x<1||y>3||y<1){
            System.out.println("Coordinates should be from 1 to 3!");
            flag = true;
        }else{
        if (arr[3-y][x-1] =='X'||arr[3-y][x-1]== 'O'){
        System.out.println("This cell is occupieded! Choose another one!");
        flag = true;
        }else {
               arr[3-y][x-1] = currentPlayerMark;
                flag = true;
                currentPlayerMark = changePlayer(currentPlayerMark);
                printBoard(arr);
                if (checkForWin(arr)){
                char winner = playerHasWon(arr);
                System.out.println(winner + "wins");
                }else{
                if (boardFull(arr)== true){
                System.out.println("Draw");
                complete = false;
                }else{
                complete = true;}
                }}
                }}
        }
        while(complete || flag);
        
        
    }
    
}
