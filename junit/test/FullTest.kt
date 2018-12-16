class FullTest {
    
    //mock some dependencies
    val game = Game()
    
    @Before
    fun init() {
        //clear game before every test
        game.clearTeams()
    }

    @After
    fun uninit() {
        //clear game before every test
        game.stop()
    }
    //use @BeforeClass, @AfterClass in the same way

    @Ignore //ignore this test temporary
    fun startGameWithDifferentTeamsSize() {
        game.addPlayer(Game.Team.RED, "Johnnie")
        game.addPlayer(Game.Team.BLUE, "Jack")
        game.addPlayer(Game.Team.BLUE, "Jim")
        game.start()
        assertFalse(game.hasStarted())
    }

    @Test(timeout = 1000) //after 1000ms when test couldn't finished than just failed
    fun startAndStopGame() {
        game.addPlayer(Game.Team.RED, "Johnnie")
        game.addPlayer(Game.Team.RED, "William")
        game.addPlayer(Game.Team.BLUE, "Jack")
        game.addPlayer(Game.Team.BLUE, "Jim")
        game.start()
        assertTrue(game.hasStarted())
        game.stop()
        assertFalse(game.hasStarted())
    }

    @Test
    fun modifyTeamsAndStartGame() {
        game.addPlayer(Game.Team.RED, "Johnnie")
        game.addPlayer(Game.Team.RED, "William")
        game.addPlayer(Game.Team.BLUE, "Jack")
        game.start()
        assertFalse(game.hasStarted())
        game.removePlayer("William")
        game.start()
        assertTrue(game.hasStarted())
    }
}