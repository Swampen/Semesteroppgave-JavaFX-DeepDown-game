package deepDown;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class LevelEditor {
    private Image image;
    private GraphicsContext gc;

    public LevelEditor(Image image, GraphicsContext gc){
        this.image = image;
        this.gc = gc;
    }

    public int[][] getLevelArray(){
        int[][] levelArray = new int[18][32];
        for (int i = 0; i < levelArray.length; i++) {
            for (int j = 0; j < levelArray[i].length; j++) {
                if ((i == 0) || (i == 17) || (j == 0) || (j == 31)){
                    levelArray[i][j] = 1;
                    gc.drawImage(image, 0, 0, 40, 40, j * 32, i * 32, 32, 32);
                } else {
                    gc.fillRect(j * 32, i * 32, 32, 32);
                    levelArray[i][j] = 0;
                }

            }
            System.out.println();
        }
        return levelArray;
    }

    public void updateArray(int[][] levelArray){
        for (int i = 1; i < levelArray.length - 1; i++) {
            for (int j = 1; j < levelArray[i].length - 1; j++) {
                int arrayInteger = levelArray[i][j];
                if (arrayInteger != 0) {
                    if (arrayInteger == 1) {
                        gc.fillRect(j * 32, i * 32, 32, 32);
                        gc.drawImage(image, 0, 0, 40, 40, j * 32, i * 32, 32, 32);
                    }
                    if (arrayInteger == 2) {
                        gc.fillRect(j * 32, i * 32, 32, 32);
                        gc.drawImage(image, 40, 0, 40, 40, j * 32, i * 32, 32, 32);
                    }
                    if (arrayInteger == 3) {
                        gc.fillRect(j * 32, i * 32, 32, 32);
                        gc.drawImage(image, 80, 0, 40, 40, j * 32, i * 32, 32, 32);
                    }
                    if (arrayInteger == 4) {
                        gc.fillRect(j * 32, i * 32, 32, 32);
                        gc.drawImage(image, 80, 0, 40, 40, j * 32, i * 32, 32, 32);
                    }
                    if (arrayInteger == 5 && !Limit.isKeyLimit()) {
                        gc.fillRect(j * 32, i * 32, 32, 32);
                        gc.drawImage(image, 120, 0, 40, 40, j * 32, i * 32, 32, 32);
                        Limit.setKeyLimit(true);
                    }
                    if (arrayInteger == 6 && !Limit.isDoorLimit()) {
                        gc.fillRect(j * 32, i * 32, 32, 32);
                        gc.drawImage(image, 160, 0, 40, 40, j * 32, i * 32, 32, 32);
                        Limit.setDoorLimit(true);
                    }
                    if (arrayInteger == 7 && !Limit.isAvatarLimit()) {
                        gc.fillRect(j * 32, i * 32, 32, 32);
                        gc.drawImage(image, 0, 40, 30, 30, j * 32 + 4, i * 32 + 4, 24, 24);
                        Limit.setAvatarLimit(true);
                    }
                }
                System.out.print(levelArray[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
