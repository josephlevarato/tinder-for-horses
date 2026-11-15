import { createFileRoute } from '@tanstack/react-router'
import { useForm, type AnyFieldApi } from '@tanstack/react-form'
import { toast } from '@yusufceng1z/ding-react'
import useHorseStore from '#/stores/auth'

interface LoginForm {
    email: string
    password: string
}

export const Route = createFileRoute('/login')({
    component: RouteComponent,
})


function FieldInfo({ field }: { field: AnyFieldApi }) {
  return (
    <>
      {field.state.meta.isTouched && !field.state.meta.isValid ? (
        <em>{field.state.meta.errors.join(',')}</em>
      ) : null}
      {field.state.meta.isValidating ? 'Validating...' : null}
    </>
  )
}

function RouteComponent() {

    async function tryLogin(email: string, password: string) {
        await fetch('/api/auth/login', {
            method: 'POST',
            credentials: 'include',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ email, password }),
        })
    }

    const form = useForm({
        defaultValues: {
            email: '',
            password: '',
        },
        onSubmit: async ({ value }) => {
            toast.promise(tryLogin(value.email, value.password), {
                loading: 'Authenticating...',
                success: 'Welcome back!',
                error: 'Wrong credentials'
            })
        }
    })
    
    return (
        <form
            onSubmit={(e) => {
                e.preventDefault()
                e.stopPropagation()
                form.handleSubmit()
            }}
        >
            <div>
                <form.Field
                    name="email"
                    validators={{
                    onChange: ({ value }) =>
                        !value
                        ? 'Field is required'
                        : value.length < 3
                            ? 'First name must be at least 3 characters'
                            : undefined,
                    onChangeAsyncDebounceMs: 500,
                    onChangeAsync: async ({ value }) => {
                        await new Promise((resolve) => setTimeout(resolve, 1000))
                        return (
                        value.includes('error') && 'No "error" allowed in email'
                        )
                    },
                    }}
                    children={(field) => {
                    return (
                        <>
                        <label htmlFor={field.name}>Email:</label>
                        <input
                            id={field.name}
                            name={field.name}
                            value={field.state.value}
                            onBlur={field.handleBlur}
                            type="email"
                            onChange={(e) => field.handleChange(e.target.value)}
                        />
                        <FieldInfo field={field} />
                        </>
                    )
                    }}
                />
            </div>
            <div>
                <form.Field
                    name="password"
                    validators={{
                    onChange: ({ value }) =>
                        !value
                        ? 'Field is required'
                        :  undefined,
                    onChangeAsyncDebounceMs: 500,
                    onChangeAsync: async ({ value }) => {
                        await new Promise((resolve) => setTimeout(resolve, 1000))
                        return (
                        value.includes('error') && 'No "error" allowed in password'
                        )
                    },
                    }}
                    children={(field) => {
                    return (
                        <>
                        <label htmlFor={field.name}>Password:</label>
                        <input
                            id={field.name}
                            name={field.name}
                            value={field.state.value}
                            onBlur={field.handleBlur}
                            type="password"
                            onChange={(e) => field.handleChange(e.target.value)}
                        />
                        <FieldInfo field={field} />
                        </>
                    )
                    }}
                />
            </div>
            <form.Subscribe
                selector={(state) => [state.canSubmit, state.isSubmitting]}
                children={([canSubmit, isSubmitting]) => (
                    <button type="submit" disabled={!canSubmit}>
                        {isSubmitting ? '...' : 'Submit'}
                    </button>
                )}
            />



        </form>
    )
}
