package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CandidatoTest.class, PostulacionVOTest.class, PublicacionVOTest.class, 
				ReporteVOTest.class, PublicacionTest.class, ReporteControllerTest.class,
				CandidatoControllerTest.class, PublicacionControllerTest.class,
				EmpresaTest.class })
public class AllTests {

}
