# SPRING ADVANCED

## 간단 API 정리
| API   | Method | Endpoint                           | Request Body                          |
|-------|--------|------------------------------------|---------------------------------------|
| `auth` |        |                                    |                                       |
| 회원 가입 | POST   | /auth/signup                       | `{ "email": "", "password": "", "userRole": "" }` |
| 로그인   | POST   | /auth/signin                       | `{ "email": "", "password": "" }`     |
| `comment` |        |                                    |                                       |
| 댓글 삭제 | DELETE | /admin/comments/{commentId}        |                                       |
| 댓글 작성 | POST   | /todos/{todoId}/comments           | `{ "contents": "" }`                  |
| 댓글 조회 | GET    | /todos/{todoId}/comments           |                                       |
| `manager` |        |                                    |                                       |
| 담당자 추가 | POST   | /todos/{todoId}/managers           | `{ "managerUserId": "" }`             |
| 담당자 조회 | GET    | /todos/{todoId}/managers           |                                       |
| 담당자 삭제 | DELETE | /todos/{todoId}/managers/{managerId} |                                       |
| `todo` |        |                                    |                                       |
| 투두 작성 | POST   | /todos                             | `{ "title": "", "content": "" }`      |
| 투두 페이지 조회 | GET    | /todos                             | `?page=&size=`                        |
| 투두 조회 | GET    | /todos/{todoId}                    |                                       |
| `user`|        |                                    |                                       |
| 사용자 역할 갱신 | PATCH  | /admin/users/{userId}              | `{ "userRole": "" }`                  |
| 사용자 전체 조회 | GET    | /users                             |                                       |
| 사용자 비밀번호 갱신 | PUT    | /users/{userId}                    | `{ "oldPassword": "", "newPassword": "" }` |
