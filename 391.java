class Solution {
    public boolean isRectangleCover(int[][] rs) {
        //my thoughts: every dot should apprea twice except for the four cornor points
        Set<String> Set = new HashSet<>();
        for (int[] r : rs) {
            String a = r[0] + " " + r[1];
            String b = r[2] + " " + r[3];
            String c = r[2] + " " + r[1];
            String d = r[0] + " " + r[3];
            if (!Set.add(a)) Set.remove(a);
            if (!Set.add(b)) Set.remove(b);
            if (!Set.add(c)) Set.remove(c);
            if (!Set.add(d)) Set.remove(d);
        }
        if (!(Set.size() == 4)) return false;
        else return true;
    }         
}
