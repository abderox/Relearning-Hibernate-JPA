package org.adria.metier.Presentation;

import org.adria.metier.entities.Compte;
import org.adria.metier.services.ServiceCompte;
import org.adria.metier.utils.TypeCompte;

import java.util.Date;
import java.util.List;

public class presentation {

    public static void main(String[] args)  {

        ServiceCompte sm = new ServiceCompte();

//        Compte cp = new Compte(null, 70000, new Date( ), TypeCompte.COURANT);
//        Compte cpA = sm.save(cp);
//
        List<Compte> comptes = sm.findAll();
        comptes.forEach(compte -> System.out.println(compte.toString( ))
        );

//        Compte cp = sm.findByCode(112L);
//        System.out.println("compte : "+cp.toString());

//        sm.delete(112L);
        Compte cp = sm.findByCode(113L);
        System.out.println(cp.toString());
        cp.setSolde(78500.30);
        Compte cp1 = sm.update(cp);
        System.out.println(cp1.toString());

    }
}
