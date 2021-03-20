class Solution {
    public int rectangleArea(int[][] rectangles) {
          Set<Integer> xSet = new HashSet<>();
          Set<Integer> ySet = new HashSet<>();
          for(int[] rec : rectangles){
              xSet.add(rec[0]);
              xSet.add(rec[2]);
              ySet.add(rec[1]);
              ySet.add(rec[3]);
          }
          Integer[] xArray = xSet.toArray(new Integer[0]);
          Integer[] yArray = ySet.toArray(new Integer[0]);
          Arrays.sort(xArray);
          Arrays.sort(yArray);
          Map<Integer, Integer> xMap = new HashMap<>();
          Map<Integer, Integer> yMap = new HashMap<>();
          for(int i = 0; i < xArray.length; i++){
              xMap.put(xArray[i], i);
          }
          for(int i = 0; i < yArray.length; i++){
              yMap.put(yArray[i], i);
          }
          boolean[][] grid = new boolean[xArray.length][yArray.length];
          for(int[] rec: rectangles){
              for(int x = xMap.get(rec[0]); x < xMap.get(rec[2]); x++){
                  for(int y = yMap.get(rec[1]); y < yMap.get(rec[3]); y++){
                      grid[x][y] = true;
                  }
              }
          }
          long res = 0L;
          for(int i = 0; i < grid.length; i++){
              for(int j = 0; j < grid[0].length; j++){
                  if(grid[i][j]){
                      res += (long)(xArray[i + 1] - xArray[i]) * (yArray[j + 1] - yArray[j]);
                  }
              }
          }
          res %= 1000_000_007;
          return (int)res;
    }
}
