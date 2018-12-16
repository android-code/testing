class SmallTest {

    @Test
    fun startGameWithDifferentTeamsSize() {
        val game = Game()
        game.addPlayer(Game.Team.RED, "Johnnie")
        game.addPlayer(Game.Team.BLUE, "Jack")
        game.addPlayer(Game.Team.BLUE, "Jim")
        game.start()
        assertFalse(game.hasStarted())
    }
}