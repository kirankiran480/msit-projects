
package ebt.team8.puzzle.android.model;

/**
 * Defines a receiver of {@link #tileMoved(Tile, Tile) tile move events}.
 */
public interface MoveListener
{
 /**
  * Called when a tile is moved.
  * @param from the blank tile that took place
  * of the moved tile 
  * @param to the moved tile at its new location
  */
 public void tileMoved(Tile from, Tile to);
}
