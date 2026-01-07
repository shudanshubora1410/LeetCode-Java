class Solution {
    public String simplifyPath(String path) {
        String[] parts = path.split("/");
        java.util.Deque<String> dq = new java.util.ArrayDeque<>();
        for(String p : parts){
            if(p.equals("") || p.equals(".")) continue;
            if(p.equals("..")){
                if(!dq.isEmpty()) dq.pollLast();
            } else {
                dq.addLast(p);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(String s : dq){
            sb.append("/").append(s);
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }
}
