import { Component, OnInit } from '@angular/core';
import { PhoneHttpService } from './phone-http.service';
import { PhoneResponse } from './models/phone-response.model';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Observable, Subject } from 'rxjs';

@Component({
  selector: 'app-phone',
  templateUrl: './phone.component.html',
  styleUrls: ['./phone.component.css']
})
export class PhoneComponent implements OnInit {
  readonly resultsPerPage = 3;

  offset = 0;
  numberForm: FormGroup;
  phoneResponse: PhoneResponse;

  constructor(
    private phoneService: PhoneHttpService,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.createForm();
  }

  getPhoneCombinationsFromHttp() {
    this.phoneService
      .getPhoneCombo(this.getPhoneNumber(), this.offset, this.resultsPerPage)
      .subscribe((phoneResponse: PhoneResponse) => {
        this.phoneResponse = phoneResponse;
      });
  }

  pageChange(selectedPage: number) {
    this.offset = selectedPage;
    this.getPhoneCombinationsFromHttp();
  }

  private createForm(): void {
    this.numberForm = this.fb.group({
      area: this.validateMinMax(3, 3),
      prefix: this.validateMinMax(3, 3),
      line: this.validateMinMax(4, 4)
    });
  }

  private getPhoneNumber() {
    const form = this.numberForm.value;
    let num = '';
    if (form.area) {
      num += form.area;
    }
    num += form.prefix + form.line;
    return num;
  }

  private validateMinMax(min, max) {
    return [
      '',
      [
        Validators.minLength(min),
        Validators.maxLength(max),
        Validators.pattern('[0-9]+') // validates input is digit
      ]
    ];
  }
}
