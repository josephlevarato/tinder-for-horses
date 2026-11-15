import type { Horse } from '#/types/horse'
import { createFileRoute } from '@tanstack/react-router'
import { useForm } from '@tanstack/react-form'
import { toast } from '@yusufceng1z/ding-react'
import { Link } from '@tanstack/react-router'
import useHorseStore from '#/stores/auth'
import { z } from 'zod'

import {
    Card,
    CardContent,
    CardHeader,
    CardDescription,
} from '#/components/ui/card'

import { Button } from '#/components/ui/button'
import { Input } from '#/components/ui/input'
import {
    Field,
    FieldGroup,
    FieldLabel,
    FieldDescription
} from '#/components/ui/field'

export const Route = createFileRoute('/login')({
    component: RouteComponent,
})

const ZodSchema = z.object({
    email: z.string(),
    password: z.string(),
})

function RouteComponent() {

    async function tryLogin(email: string, password: string) {
        const res = await fetch('/api/auth/login', {
            method: 'POST',
            credentials: 'include',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ email, password }),
        })
        if (!res.ok) {
            throw new Error(`Login failed (${res.status})`)
        }
    }

    async function retrieveHorse(): Promise<Horse> {
        return await fetch('/api/horses/me', {
            credentials: 'include',
            headers: { 'Content-Type': 'application/json' },
        })
            .then((r) => r.json())

    }

    const form = useForm({
        defaultValues: {
            email: '',
            password: '',
        },
        validators: {
            onChange: ZodSchema,
        },
        onSubmit: async ({ value }) => {
            try {
                await toast.promise(tryLogin(value.email, value.password), {
                    loading: 'Authenticating...',
                    success: 'Welcome back!',
                    error: 'Wrong credentials',
                })

                const horse: Horse = await retrieveHorse()
                console.log(horse)

            } catch {
                // noop
            }
        }
    })

    return (
        <div className="flex flex-col gap-6">
            <h1 className="text-3xl text-center font-bold">
                Hoof'd
            </h1>
            <Card>
                <CardHeader>
                    <CardDescription className="text-center">
                        Find your stablemate. Log in to keep trotting.
                    </CardDescription>
                </CardHeader>
                <CardContent>
                    <form
                        onSubmit={(e) => {
                            e.preventDefault()
                            e.stopPropagation()
                            form.handleSubmit()
                        }}
                    >
                        <FieldGroup>
                            <form.Field
                                name="email"
                                children={(field) => {
                                    return (
                                        <Field>
                                            <FieldLabel htmlFor={field.name}>
                                                Email
                                            </FieldLabel>
                                            <Input
                                                id={field.name}
                                                name={field.name}
                                                value={field.state.value}
                                                onBlur={field.handleBlur}
                                                aria-invalid={field.state.meta.isTouched && !field.state.meta.isValid}
                                                type="email"
                                                onChange={(e) => field.handleChange(e.target.value)}
                                            />
                                        </Field>
                                    )
                                }}
                            />

                            <form.Field
                                name="password"
                                validators={{
                                onChange: ({ value }) =>
                                    !value
                                    ? 'Field is required'
                                    :  undefined,
                                }}
                                children={(field) => {
                                    return (
                                        <Field>
                                            <FieldLabel htmlFor={field.name}>
                                                Password
                                            </FieldLabel>
                                            <Input
                                                id={field.name}
                                                name={field.name}
                                                value={field.state.value}
                                                onBlur={field.handleBlur}
                                                aria-invalid={field.state.meta.isTouched && !field.state.meta.isValid}
                                                type="password"
                                                onChange={(e) => field.handleChange(e.target.value)}
                                            />
                                        </Field>
                                    )
                                }}
                            />

                            <form.Subscribe
                                selector={(state) => [state.canSubmit, state.isSubmitting]}
                                children={([canSubmit, isSubmitting]) => (
                                    <Button type="submit" disabled={!canSubmit || isSubmitting}>
                                        Login
                                    </Button>
                                )}
                            />
                            <FieldDescription className="text-center">
                                Don&apos;t have an account? <Link to="/register">Sign up</Link>
                            </FieldDescription>
                        </FieldGroup>
                    </form>
                </CardContent>
            </Card>
        </div>
    )
}
