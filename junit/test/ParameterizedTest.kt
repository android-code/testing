@RunWith(Parameterized::class)
class ParameterizedTest(val redGoals: Int, val blueGoals: Int, val scores: String) {

    companion object {
        val game = Game()

        @BeforeClass @JvmStatic
        fun initTeams() {
            game.addPlayer(Game.Team.RED, "Johnnie")
            game.addPlayer(Game.Team.RED, "William")
            game.addPlayer(Game.Team.BLUE, "Jack")
            game.addPlayer(Game.Team.BLUE, "Jim")
        }

        @AfterClass @JvmStatic
        fun uninitTeams() {
            game.clearTeams()
        }

        //create test data
        @Parameters @JvmStatic
        fun createData(): Collection<Array<Any>> {
            return listOf(
                arrayOf(0, 2, "RED 0:2 BLUE"),
                arrayOf(10, 5, "RED 10:5 BLUE"),
                arrayOf(3, 3, "RED 3:3 BLUE"))
        }
    }

    //use auto parameterized test method
    @Test
    fun scoreAndCheckResultWithParameterized() {
        game.start()
        repeat(redGoals) { game.goal(Game.Team.RED) }
        repeat(blueGoals) { game.goal(Game.Team.BLUE) }
        assertEquals(scores, game.getScore())
        game.stop()
    }

    //instead of manual parameterized
    @Test
    fun scoreAndCheckResultNormal() {
        //first test
        game.start()
        repeat(2) { game.goal(Game.Team.BLUE) }
        assertEquals("RED 0:2 BLUE", game.getScore())
        game.stop()

        //second test
        game.start()
        repeat(10) { game.goal(Game.Team.RED) }
        repeat(5) { game.goal(Game.Team.BLUE) }
        assertEquals("RED 10:5 BLUE", game.getScore())
        game.stop()

        //third test
        game.start()
        repeat(3) { game.goal(Game.Team.RED) }
        repeat(3) { game.goal(Game.Team.BLUE) }
        assertEquals("RED 3:3 BLUE", game.getScore())
        game.stop()
    }
}