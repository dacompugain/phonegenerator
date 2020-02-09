import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { PhoneComponent } from './phone/phone.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { PhoneHttpService } from './phone/phone-http.service';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { PaginationComponent } from './shared/pagination/pagination.component';

@NgModule({
  declarations: [
    AppComponent,
    PhoneComponent,
    PaginationComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [
    PhoneHttpService,
    HttpClient,
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
