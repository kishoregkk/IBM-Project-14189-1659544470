import java.util.*;
class HillCipher 
{
 public static int[][] keymat = new int[][] { { 17, 17, 5 }, { 21, 18, 21 }, { 2, 2, 19 } };
 public static String key = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
 private static String encode(char a, char b, char c) {
 String ret = "";
 int x, y, z;
 int posa = (int) a - 65;
 int posb = (int) b - 65;
 int posc = (int) c - 65;
 x = posa * keymat[0][0] + posb * keymat[1][0] + posc * keymat[2][0];
 y = posa * keymat[0][1] + posb * keymat[1][1] + posc * keymat[2][1];
 z = posa * keymat[0][2] + posb * keymat[1][2] + posc * keymat[2][2];
 a = key.charAt(x % 26);
 b = key.charAt(y % 26);
 c = key.charAt(z % 26);
 ret = "" + a + b + c;
 return ret;
 }
 public static void main(String[] args) throws java.lang.Exception {
 String enc = "";
 int n;
 Scanner sc= new Scanner(System.in); 
System.out.print("Enter a string: ");
String msg = sc.nextLine();
 msg = msg.toUpperCase();
msg = msg.replaceAll("\\s", "");
 n = msg.length() % 3;
 if (n != 0) {
 for (int i = 1; i <= (3 - n); i++) {
 msg += 'X';
 }
 }
 System.out.println("Input message : " + msg);
 char[] pdchars = msg.toCharArray();
 for (int i = 0; i < msg.length(); i += 3) {
 enc += encode(pdchars[i], pdchars[i + 1], pdchars[i + 2]);
 }
 System.out.println("Encoded message : " + enc);
}
}