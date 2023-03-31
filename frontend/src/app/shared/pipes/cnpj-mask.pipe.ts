import {Pipe, PipeTransform} from '@angular/core';

@Pipe({
  name: 'documentNumber'
})
export class documentNumberMaskPipe implements PipeTransform {

  transform(documentNumber: string): any {
    if (documentNumber) {
      if(documentNumber.length < 10){
        return documentNumber;
      }
      if (documentNumber.length === 11) {
        return `${documentNumber.substring(0, 3)}.${documentNumber.substring(3, 6)}.${documentNumber.substring(6, 9)}-${documentNumber.substring(9, 11)}`;
      }
      return `${documentNumber.substring(0, 2)}.${documentNumber.substring(2, 5)}.${documentNumber.substring(5, 8)}/${documentNumber.substring(8, 12)}-${documentNumber.substring(12)}`;
    }
    return null;
  }
}
