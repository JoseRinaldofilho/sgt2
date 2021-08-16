import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ResponsaveisCreateComponent } from './responsaveis-create.component';

describe('ResponsaveisCreateComponent', () => {
  let component: ResponsaveisCreateComponent;
  let fixture: ComponentFixture<ResponsaveisCreateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ResponsaveisCreateComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ResponsaveisCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
