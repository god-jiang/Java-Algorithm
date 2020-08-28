package leetcode;

/**
 * leetcode657题，机器人能否返回原点
 *
 * @author god-jiang
 */
public class JudgeCircle {
    public boolean judgeCircle(String moves) {
        if (moves == null || moves.length() == 0) {
            return false;
        }
        int x = 0;
        int y = 0;
        if ((moves.length() & 1) == 1) {
            return false;
        }
        for (int i = 0; i < moves.length(); i++) {
            switch (moves.charAt(i)) {
                case 'L':
                    x++;
                    break;
                case 'R':
                    x--;
                    break;
                case 'U':
                    y++;
                    break;
                case 'D':
                    y--;
                    break;
            }
        }
        return x == 0 && y == 0;
    }
}
