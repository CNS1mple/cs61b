// 表面是eary，实际是hard（面试的时候会要求考虑大数，算法就假了。
// 真算法是 字符串全排列

class Solution {
    char[] c = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    char[] res_item;
    StringBuilder res;
    int n, start, count;

    public String printNumbers(int n) {
        if(n < 1) return "";
        this.n = n; start = n - 1; count = 0;
        res_item = new char[n];
        res = new StringBuilder();
        dfs(0);
        res.deleteCharAt(res.length() - 1);
        return res.toString();
    }

    private void dfs(int x) {
        if(x == n) {
            String s = String.valueOf(res_item).substring(start);
            if(!s.equals("0")) res.append(s + ",");
            if(start + count == n) start--;
            return;
        }
        for(char item : c) {
            if(item == '9') count++;
            res_item[x] = item;
            dfs(x + 1);
        }
        count --;
    }
}
