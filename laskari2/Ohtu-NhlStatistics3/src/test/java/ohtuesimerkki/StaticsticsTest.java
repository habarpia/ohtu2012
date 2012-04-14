package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import org.junit.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class StaticsticsTest {

//    Statistics stats;
//    PlayerReader palayerReader = new PlayerReader() {
//
//        public List<Player> getPlayers() {
//            ArrayList<Player> players = new ArrayList<Player>();
//
//            players.add(new Player("Semenko", "EDM", 4, 12));
//            players.add(new Player("Lemieux", "PIT", 45, 54));
//            players.add(new Player("Kurri", "EDM", 37, 53));
//            players.add(new Player("Yzerman", "DET", 42, 56));
//            players.add(new Player("Gretzky", "EDM", 35, 89));
//
//            return players;
//        }
//    };
    

    @Before
    public void setUp() {
//        stats = new Statistics(palayerReader);
      //  statistics = new Statistics(mockReader);
    }

    @Test
    public void playerFound() {
        PlayerReaderImpl mockReader = mock(PlayerReaderImpl.class);
        ArrayList<Player> players = new ArrayList<Player>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri", "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
        
        when(mockReader.getPlayers()).thenReturn(players);
        
        Statistics statistics = new Statistics(mockReader);
        
        
        
        Player p = statistics.search("Lemieux");
        
        verify(mockReader).getPlayers();
        assertEquals("PIT", p.getTeam());
        assertEquals(45, p.getGoals());
        assertEquals(54, p.getAssists());
        assertEquals(45 + 54, p.getPoints());
        
        

    }
    
    @Test
    public void teamMembersFound(){
        PlayerReaderImpl mockReader = mock(PlayerReaderImpl.class);
        ArrayList<Player> players = new ArrayList<Player>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri", "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
        
        when(mockReader.getPlayers()).thenReturn(players);
        
        Statistics statistics = new Statistics(mockReader);
        
        List<Player> team = statistics.team("EDM");
        assertEquals(3, team.size());
        for (Player player : team) {
            assertEquals("EDM", player.getTeam());
        }
    }
    
    @Test
    public void topScorersFound(){
        PlayerReaderImpl mockReader = mock(PlayerReaderImpl.class);
        ArrayList<Player> players = new ArrayList<Player>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri", "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
        
        when(mockReader.getPlayers()).thenReturn(players);
        
        Statistics statistics = new Statistics(mockReader);
        
        List<Player> top = statistics.topScorers(2);
        assertEquals(3, top.size());
        assertEquals("Gretzky", top.get(0).getName());
        assertEquals("Lemieux", top.get(1).getName());
    }
}
