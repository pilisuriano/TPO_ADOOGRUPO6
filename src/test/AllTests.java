package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CandidatoVOTest.class, PostulacionVOTest.class, PublicacionVOTest.class, 
				ReporteVOTest.class, PublicacionTest.class, ReporteControllerTest.class,
				CandidatoControllerTest.class, PublicacionControllerTest.class })
public class AllTests {

}