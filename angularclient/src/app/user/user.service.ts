import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from './user';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  private usersUrl = 'http://localhost:8080/users';

  // Use the `inject` function to get an instance of HttpClient
  private http = inject(HttpClient);

  public findAll(): Observable<User[]> {
    return this.http.get<User[]>(this.usersUrl);
  }

  public save(user: User): Observable<User> {
    return this.http.post<User>(this.usersUrl, user);
  }
}
