package testing;

import org.junit.Test;
// Testing for enemy Movement
// @author Luke Freudenthal

import things.Enemy;

public class EnemyTesting {

	Enemy enemy = new Enemy(0, 0, 0, 0);
	
	@Test
	public void testEnemyMovement() {
		int ticker = 0;
		double enemyStart = enemy.getY();
		for(int i = 0; i < 300; i++) {
			enemy.move();
		}
		assert(enemy.getY() < enemyStart);
	}

}
