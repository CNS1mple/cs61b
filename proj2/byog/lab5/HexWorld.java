package byog.lab5;
import org.junit.Test;
import static org.junit.Assert.*;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import javax.swing.text.Position;
import java.util.Random;

/**
 * Draws a world consisting of hexagonal regions.
 */
public class HexWorld {
    private static final int WIDTH = 40;
    private static final int HEIGHT = 30;

    private static final long SEED = 2873123;
    private static final Random RANDOM = new Random(SEED);

    public static class Position {
        int x, y;
        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void addHexagon(TETile[][] world, Position pos, TETile t, int n) {
        Position newPos = new Position(pos.x, pos.y);
        int cnt = n;
        for(int i = 0; i < n; i++) {
            drawRow(world, newPos, cnt, t);
            cnt += 2;
            newPos.x--;
            newPos.y++;
        }
        newPos.x++;
        cnt -= 2;
        for(int i = n - 1; i >= 0; i--) {
            drawRow(world, newPos, cnt, t);
            cnt -=2;
            newPos.x++;
            newPos.y++;
        }
    }

    private static void drawBackground(TETile[][] world) {
        for(int i = 0; i < WIDTH; i++) {
            for(int j = 0; j < HEIGHT; j++) {
                world[i][j] = Tileset.NOTHING;
            }
        }
    }


    private static boolean outOfBounds(int i, int j) {
        if(i < 0 || i >= WIDTH || j < 0 || j >= HEIGHT) return true;
        return false;
    }
    private static TETile[][] drawRow(TETile[][] world, Position pos, int cnt, TETile t) {
        for(int i = pos.x; i < pos.x + cnt; i++) {
            if(outOfBounds(i, pos.y)) continue;
            world[i][pos.y] = t;
        }
        return world;
    }

    public static void generate(TETile world[][],  int n) {
        Position pos = new Position(n, HEIGHT / 2 - n * 3);
        drawAColumnOfHexagon(world, n, 3, pos);
        pos.x += n * 2 - 1;
        pos.y -= n;
        drawAColumnOfHexagon(world, n, 4, pos);
        pos.x += n * 2 - 1;
        pos.y -= n;
        drawAColumnOfHexagon(world, n, 5, pos);
        pos.x += n * 2 - 1;
        pos.y += n;
        drawAColumnOfHexagon(world, n, 4, pos);
        pos.x += n * 2 - 1;
        pos.y += n;
        drawAColumnOfHexagon(world, n, 3, pos);
    }

    private static void drawAColumnOfHexagon(TETile[][] world, int n, int count, Position pos) {
        Position tempPos = new Position(pos.x, pos.y);
        for(int i = 0; i < count; i++) {
            addHexagon(world, tempPos, randomTile(), n);
            tempPos.y += 2 * n;
        }
    }

    private static TETile randomTile() {
        int tileNum = RANDOM.nextInt(5);
        switch (tileNum) {
            case 0: return Tileset.WALL;
            case 1: return Tileset.FLOWER;
            case 2: return Tileset.TREE;
            case 3: return Tileset.SAND;
            case 4: return Tileset.MOUNTAIN;
            default: return Tileset.NOTHING;
        }
    }

//    public static void generateWorld(TETile[][] world, int n) {
//        Position pos = new Position(WIDTH / 2 - n / 2, 0);
//        generateWorld(world, pos, Tileset.TREE, n);
//    }

//    private static void generateWorld(TETile[][] world, Position pos, TETile t, int n) {
//        if(outOfBounds(pos.x, pos.y)) return;
//        addHexagon(world, pos, t, n);
//        generateWorld(world, new Position(pos.x - (2 * n - 1), pos.y + n), Tileset.WALL, n);
//        generateWorld(world, new Position(pos.x + (2 * n - 1), pos.y + n), Tileset.WATER, n);
//    }

    public static void main(String[] args) {
        TERenderer ter = new TERenderer();
        ter.initialize(WIDTH, HEIGHT);
        TETile[][] world = new TETile[WIDTH][HEIGHT];
        drawBackground(world);
//        addHexagon(world, new Position(10, 10), Tileset.TREE, 4);
        generate(world, 3);
        ter.renderFrame(world);
    }
}
