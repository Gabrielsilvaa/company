import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'customDatePipe'
})
export class CustomDatePipe implements PipeTransform {

  transform(date: any): any {
    if (date) {
      if(date.length < 6){
        return date;
      }
      if (date.length === 6) {
        return `${date.substring(0, 2)}-${date.substring(2, 4)}-${date.substring(4, 7)}`;
      }
      return `${date.substring(0, 2)}-${date.substring(2, 4)}-${date.substring(4, 9)}`;
    }
    return null;
  }

}
