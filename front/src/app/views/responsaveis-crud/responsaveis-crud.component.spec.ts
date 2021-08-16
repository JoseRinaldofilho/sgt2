import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ResponsaveisCrudComponent } from './responsaveis-crud.component';

describe('ResponsaveisCrudComponent', () => {
  let component: ResponsaveisCrudComponent;
  let fixture: ComponentFixture<ResponsaveisCrudComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ResponsaveisCrudComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ResponsaveisCrudComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
