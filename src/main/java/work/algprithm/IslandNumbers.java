package work.algprithm;

/**
 * @author zhailzh
 * 
 * @Date 20151137:39:18
 * 
 *       01 
 */
public class IslandNumbers {

  public static void main(String[] args) {
    int[][] islandData = { { 1, 0, 0, 0, 1, 1 }, { 1, 0, 0, 0, 0, 0 }, { 1, 0, 0, 0, 1, 1 }, { 1, 0,
        0, 0, 1, 1 }, { 0, 0, 0, 0, 0, 0 }, { 1, 0, 0, 0, 1, 1 }, { 1, 0, 0, 0, 1, 1 } };

    int islandNum = findIslandNums(islandData);

    System.out.println("еĵ" + islandNum);
  }

  private static int findIslandNums(int[][] islandData) {
    boolean[][] is = new boolean[islandData.length][islandData[0].length];
    for (int i = 0; i < islandData.length; i++) {
      for (int j = 0; j < islandData[i].length; j++) {
        if (islandData[i][j] == 1) {
          is[i][j] = true;
        } else {
          is[i][j] = false;
        }
      }
    }

    int number = 0;
    for (int i = 0; i < islandData.length; i++) {
      for (int j = 0; j < islandData[i].length; j++) {
        if (is[i][j]) {
          number++;
          changeFlag(is, i, j);
        }
      }
    }
    return number;
  }

  private static void changeFlag(boolean[][] is, int i, int j) {
    if (i + 1 < is.length && j < is[0].length && is[i + 1][j]) {
      is[i + 1][j] = false;
      changeFlag(is, i + 1, j);
    }
    if (i < is.length && j + 1 < is[0].length && is[i][j + 1]) {
      is[i][j + 1] = false;
      changeFlag(is, i, j + 1);
    }
  }

}
