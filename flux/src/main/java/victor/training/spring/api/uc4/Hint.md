<details> 
  <summary>Hint 1: Issues with `org.springframework.security.core.context.SecurityContext` </summary>
   - Use `org.springframework.security.core.context.ReactiveSecurityContextHolder` instead of `org.springframework.security.core.context.SecurityContextHolder`.
</details>

<details> 
  <summary>Hint 2: Not sure what to use instead of `org.springframework.amqp.rabbit.core.RabbitTemplate` in Reactive App </summary>
   - Try to use `reactor.rabbitmq.Sender` instead of `org.springframework.amqp.rabbit.core.RabbitTemplate`.
</details>

<details> 
  <summary>Hint 3: Tests are stuck </summary>
   - Try to use `reactor.rabbitmq.Sender` instead of `org.springframework.amqp.rabbit.core.RabbitTemplate`.
</details>
