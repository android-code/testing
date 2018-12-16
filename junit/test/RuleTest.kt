class RuleTest {

    @Rule @JvmField
    val rule = PrintTestRule() //this rule print message before and after every test

    val game = Game()

    @Test
    fun addPlayersWithSameNameToTheSameTeam() {
        game.addPlayer(Game.Team.RED, "Johnnie")
        game.addPlayer(Game.Team.RED, "William")
        game.addPlayer(Game.Team.RED, "Jack")
        game.addPlayer(Game.Team.RED, "William")
        assertEquals(3, game.getRedTeam().size)
    }

    @Test
    fun addPlayersWithSameNameToTheAnotherTeam() {
        game.addPlayer(Game.Team.RED, "Johnnie")
        game.addPlayer(Game.Team.RED, "William")
        game.addPlayer(Game.Team.BLUE, "Jack")
        game.addPlayer(Game.Team.BLUE, "William")
        assertEquals(1, game.getBlueTeam().size)
    }
}