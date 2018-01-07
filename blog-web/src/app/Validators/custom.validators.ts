import { AbstractControl, ValidationErrors } from "@angular/forms";

export class customValidators {
    constructor() {
    }
    /**
     * Validator to check if input contains space
     * @param control
     */
    static containsSpace(control:AbstractControl):ValidationErrors | null{
        if((control.value as string).indexOf(' ')>=0)
            return { containsSpace : true};
        return null;
    }
    /**
     * Validator to validate email
     * @param control 
     */
    static validateEmail(control: AbstractControl): ValidationErrors | null {
        let EMAIL_REGEXP = /^[a-zA-Z0-9_.+-]+@(?:(?:[a-zA-Z0-9-]+\.)?[a-zA-Z]+\.)?(yopmail)\.com$/;

        return EMAIL_REGEXP.test(control.value) ? null : {
            validate:false
        };
    }
}