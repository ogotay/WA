/**
 * 
 */
package test;

import static org.junit.Assert.*;

import main.CharacterSkills;
import main.CharacterSkillsBoundaries;

import org.junit.Before;
import org.junit.Test;

import character.BasicStatistic;


public class CharacterSkillsTest {

	private BasicStatistic toughness;
	private BasicStatistic fightingSkill;
	private CharacterSkills stats;

	
	@Before
	public void setUp(){
		//toughness = new BasicStatistic(15);
		//fightingSkill = new BasicStatistic(25);
		//stats = new CharacterSkills(toughness, fightingSkill);
		
	}
	
	@Test
	public void shouldHaveAllStatisticsInValidRange(){
		//TODO: Change to test various scenarios with different boundary conditions.
		//assertTrue(stats.toughness.getValue() >= CharacterSkillsBoundaries.MIN_TOUGHNESS);
		//assertTrue(stats.toughness.getValue() < CharacterSkillsBoundaries.MAX_TOUGHNESS);
		
		//assertTrue(stats.fightingSkill.getValue() >= CharacterSkillsBoundaries.MIN_FIGHTING_SKILL);
		//assertTrue(stats.fightingSkill.getValue() < CharacterSkillsBoundaries.MAX_FIGHTING_SKILL);
		
		//assertThat(stats.toughness.getValue(), is(CharacterSkillsBoundaries.MIN_TOUGHNESS));
		//assertThat(stats.toughness.getValue(), is(CharacterSkillsBoundaries.MAX_TOUGHNESS));
		
		//assertThat(stats.fightingSkill.getValue(), is(greaterThanOrEqualTo(CharacterSkillsBoundaries.MIN_FIGHTING_SKILL)));
		//assertThat(stats.fightingSkill.getValue(), is(lessThan(CharacterSkillsBoundaries.MAX_FIGHTING_SKILL)));
		
	}

}
