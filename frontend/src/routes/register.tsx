import { createFileRoute } from '@tanstack/react-router'
import { useForm } from '@tanstack/react-form'

import {
    Card,
    CardContent,
    CardHeader,
    CardDescription,
} from '#/components/ui/card'

export const Route = createFileRoute('/register')({
  component: RouteComponent,
})

function RouteComponent() {
    return (
        <div className="flex flex-col gap-6">
            <h1 className="text-3xl text-center font-bold">
                Join the herd
            </h1>
            <Card>
                <CardHeader>
                    <CardDescription className="text-center">
                        Create your account, then build your profile.
                    </CardDescription>
                </CardHeader>
                <CardContent>

                </CardContent>
            </Card>
        </div>
    )
}
