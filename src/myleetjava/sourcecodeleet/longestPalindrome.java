package myleetjava.sourcecodeleet;

public class longestPalindrome {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }

    public static String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String ans = "";
        for (int l = 0; l < n; l++) {
            for(int i=0;i+l<n;i++){
                int j=i+l;
                if(l==0){
                    dp[i][j]=true;
                }else if(l==1){
                    dp[i][j]=(s.charAt(i)==s.charAt(j));
                }else{
                    dp[i][j]=(s.charAt(i)==s.charAt(j)&&dp[i+1][j-1]);
                }
                System.out.println("k: "+i+" p: "+j+" dp: "+dp[i][j]);
                if(dp[i][j]&&l+1>ans.length()){
                    ans =s.substring(i,i+l+1);
                    System.out.println(i+"TTT"+(i+l+1));
                }
            }
        }
        return ans;
    }
}
