import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';

@Injectable()
export class PhoneHttpService {
  private readonly phoneServiceUrl = 'http://localhost:8080/phone';
  constructor(private http: HttpClient) {}

  getPhoneCombo(phoneNumber: string, skip: number, take: number) {
    const params = new HttpParams({
      fromObject: {
        number: phoneNumber,
        skip: skip.toString(),
        take: take.toString()
      }
    });
    return this.http.get(this.phoneServiceUrl, { params });
  }
}
