class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits == null || digits.length() == 0){
            return result;
        }
        char[][] map = new char[8][];
        map[0]="abc".toCharArray();
        map[1]="def".toCharArray();
        map[2]="ghi".toCharArray();
        map[3]="jkl".toCharArray();
        map[4]="mno".toCharArray();
        map[5]="pqrs".toCharArray();
        map[6]="tuv".toCharArray();
        map[7]="wxyz".toCharArray();
        char [] input = digits.toCharArray();
        result.add("");
        for(char c: input){
            result = append(result, map[c-'2']);
        }
        return result;
    }
    private List<String> append(List<String> temp, char [] chars){
        List<String> res = new ArrayList<>();
        for(String s: temp){
            for(char c: chars){
                res.add(s+c);
            }
        }
        return res;
    }
}
