/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.guestu.testdrools2;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;


/**
 *
 * @author super
 */
public class DroolsTest {
   public static final void main(String[] args) {
		try {
			KieServices ks = KieServices.Factory.get();
			KieContainer kContainer = ks.getKieClasspathContainer();
//Get the session named kseesion-rule that we defined in kmodule.xml above.
//Also by default the session returned is always stateful. 
			KieSession kSession = kContainer.newKieSession("ksession-rule");

			Product product = new Product();
			product.setType("wood");

			FactHandle fact1;
                  if(kSession==null) System.out.println("kSesison null");
			fact1 = kSession.insert(product);
			kSession.fireAllRules();
                        

			System.out.println("The discount for the jewellery product "
					+ product.getType() + " is " + product.getDiscount());

		} catch (Throwable t) {
			t.printStackTrace();
		}
	}
}
