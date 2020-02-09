import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PhoneComponent } from './phone.component';
import { PhoneHttpService } from './phone-http.service';
import { PaginationComponent } from '../shared/pagination/pagination.component';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { FormBuilder } from '@angular/forms';

describe('PhoneComponent', () => {
  let component: PhoneComponent;
  let fixture: ComponentFixture<PhoneComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PhoneComponent ],
      imports: [HttpClientModule],
      providers: [PhoneHttpService, HttpClient, FormBuilder],
    }).overrideComponent(PaginationComponent, {
      set: {
        template: ''
      }
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PhoneComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
