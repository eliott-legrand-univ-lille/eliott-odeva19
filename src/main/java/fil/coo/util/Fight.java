package fil.coo.util;

import java.util.List;

/**
 *  <b> Class that represent a Fight </b>
 *  
 *  <p> A fight is possible when there are monster in the room, when the Fight is 
 *  executed the Player choose a Monster to fight </p>
 *  
 *  @see Action
 *  
 * @author legrand,santi
 *
 */
public class Fight extends Action {

	@Override
	public boolean isPossible(Player p) {
		List<Monster> monsters;
		monsters = p.getActualRoom().getMonsters();
		if(monsters.isEmpty()) {
			return false;
		}
		return true;
	}

	@Override
	public void execute(Player p) {
		Menu m=new Menu();
		Monster monster;
		if (p.getActualRoom().getMonsters().size()>1){
			monster=m.choose("Choose a monster to fight",p.getActualRoom().getMonsters());
		}
		else{
			monster=p.getActualRoom().getMonsters().get(0);
		}
		if (monster!=null) {
			p.attack(monster);
			if (!monster.isDead()) {
				monster.attack(p);
			}
		}
	}
}
