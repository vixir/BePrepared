public class CountSubsequence
{
  public static void main (String[] args) {
		String a = "abcabbbcabc";
		String b = "abbc";
	    char[] aArr = a.toCharArray();
	    char[] bArr = b.toCharArray();
	    System.out.println(count(aArr,bArr,aArr.length,bArr.length));
	}
	
	
	public static int count(char []a, char []b, int aLen, int bLen){
	    int ans[][] = new int[aLen+1][bLen+1];
	    for(int i=0;i<=aLen;i++){
	        ans[i][0] = 1;
	    }
	    for(int i=1;i<=aLen;i++){
	        for(int j=1;j<=bLen;j++){
	               if(a[i-1]==b[j-1]){
	                   ans[i][j] = ans[i-1][j]+ans[i-1][j-1];
	               }else{
	                   ans[i][j] = ans[i-1][j];
	               }
	        }
	    }
	    return ans[aLen][bLen];
	}

}
