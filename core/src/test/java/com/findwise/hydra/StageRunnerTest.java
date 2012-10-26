package com.findwise.hydra;

import static org.junit.Assert.*;

import java.io.File;
import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.findwise.hydra.StageRunner.StageDestroyer;

public class StageRunnerTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRun() {
		
	}

	@Test
	public void testDestroy() throws Exception {
		StageDestroyer sd = new StageDestroyer();
		Process p = Mockito.mock(Process.class);
		sd.add(p);
		
		StageGroup group = new StageGroup("group");
		Stage mockedStage = Mockito.mock(Stage.class);
		group.add(mockedStage);
		Mockito.when(mockedStage.getProperties()).thenReturn(new HashMap<String, Object>());
		
		StageRunner sr = new StageRunner(group, new File("test"), 0);
		sr.setStageDestroyer(sd);
		
		sr.destroy();
		
		Mockito.verify(p, Mockito.times(1)).destroy();
	}

}
