/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author Toky_Ravelojaona
 */

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)

public @interface Correspondance {
    public String nomTable() default"";

    public String nomColonne() default"";

    public boolean foreignkey() default false;

    public String foreignkeyColonne() default "";

    public boolean primarykey() default false;
    
    public String typeColonne() default "";
}
